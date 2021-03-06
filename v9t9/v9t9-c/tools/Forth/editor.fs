
\   V9t9 FORTH Block Editor.
\

[[[
>minimal
\ : HIDE  ; immediate
: HIDE | ; immediate
>target 
]]]

HIDE 4 constant tab-size

\   Cursor column 
HIDE User 'col       ( 0 - c/l )

\   Return number of columns left on the line
HIDE : #left  ( -- left )
    c/l  'col @ -
;

\   Point to cursor position on the line
HIDE : >curs  ( laddr -- caddr )
    'col @ +
;

\   Set up a move between the current and next character
HIDE : >ch-mov ( laddr -- pos+1 pos n )
    #left 1- >r         ( laddr n ) 
    >curs dup 1+ r>         ( dst src n )
;    

\ Those operations operate on a single line at a time.
\ They read and write 'col.
\ 'laddr' is the line's base address.

\   Delete a character at the current spot and add blank at end.
HIDE : ^del  ( laddr -- )
    dup >r
    >ch-mov >r swap r>          ( ch pos+1 pos n )
    cmove  
    bl r> c/l + 1- c!              ( put char at the end )
;

\   Clear from the start to the cursor
HIDE : ^clear-start   ( laddr -- )
    'col @ bl fill 
;

\   Clear from the cursor to the end
HIDE : ^clear-end   ( laddr -- )
    >curs #left bl fill 
;


\   Backspace-delete the character at the current spot and bump the cursor.
\   Yield the line adjustment (0 or -1) depending on if we hit the beginning.
HIDE : ^bksp ( laddr -- ladj )
    'col @ dup 0= if
        c/l 'col !
    then
    ( laddr col )
    0= swap     ( ladj laddr )
    -1 'col +!
    ^del
;

\   Backspace to the given column
\
HIDE : ^bksp-to ( laddr col -- )
    >r
    'col @ r@ ?do  
        dup ^bksp drop  
    loop
    drop
    r> 'col ! 
;


\   Move the cursor left or right, indicating whether a line adjustment
\   is needed when one end or the other is hit.
HIDE : ^curs ( cadj -- ladj )
    'col +! 
    'col @  dup  0< if
        drop  
        c/l 1- 'col !   -1
    else 
        c/l >= if
            0 'col !     1
        else
                         0
        then
    then
;    

\   Insert a character at the current spot and bump the cursor.
\   Yield the line adjustment (0 or 1) depending on if we hit the end.
HIDE : ^ins  ( ch laddr -- ladj )
    >ch-mov                     ( pos pos+1 n ) 
    over 1- >r cmove>
    r> c!                       ( inject char )
    1 ^curs
;

\   Set the character at the current spot and bump the cursor.
\   Yield the line adjustment (0 or 1) depending on if we hit the end.
HIDE : ^chr ( ch laddr -- ladj )
    >curs c!
    1 ^curs
;

\   Find the beginning of the line, either the first non-whitespace char of a line,
\   or the absolute beginning if only whitespace precedes.
HIDE : >home ( laddr -- col )
    'col @ 0 do             \ HACK! if 'col is 0, loops forever...
        dup i +  c@  bl > 
        i c/l >=         \ ... and we terminate here
        or if
            drop  i c/l mod  unloop  ( col ) exit
        then
    loop
    drop  0
;


\   Move to the first non-whitespace char of a line,
\   or the absolute beginning if only whitespace precedes.
HIDE : ^home ( laddr -- )
    >home 'col !
;

\   Move past the last non-whitespace char of a line (backing up if already beyond it)
HIDE : ^end ( laddr -- )
   0 c/l  do         \ reverse loop
        dup i 1- +  c@  bl > if
            drop  i 'col !  unloop exit
        then
    -1 +loop
    drop 0 'col !
;

\   insert or overwrite a character (insert or overwrite), 
\   yielding line adjustment if we hit the end
HIDE : ^char  ( ch laddr -- ladj )
    ovr @ if ^chr else ^ins then
;

\   Find the next tab position in the given direction
\   (on the same line)
HIDE : +tab ( col dir -- col )
    0> if
        tab-size + c/l min
    else
        tab-size - 0 max
    then
    tab-size negate and
;

\   Find a character, matching a given test relative to whitespace.
\   If the current char matches the test,
\   that col is returned.  Stops at endcol.
HIDE : >ws?   ( laddr endcol col dir test-xt [ chr bl -- t|f ] -- col ) 
    >r >r
    over swap ?do ( laddr endcol )
        over i + c@ bl  j'  execute
        if
            i unloop nip nip unloop exit
        then
    j +loop
    unloop nip
;

\   Find the next tab position in the given direction, stopping either
\   when that position is reached, or the line has a
\   non-whitespace character following whitespace.
HIDE : >tab ( laddr col dir -- col )
    \ find where to tab to
    dup >r
    over >r       ( r: dir col )
    +tab          ( laddr tabcol )

    \ skip to whitespace
    2dup r> r@ ['] <= >ws? ( laddr tabcol wscol )  ( r: dir )  
    
    \ if wscol == tabcol, then tabcol is the target
    2dup = if
        drop nip rdrop ( col )
    else
        \ else, find non-whitespace between here and there
        r> ['] >  >ws?  ( col )
    then
; 

\   Cursor line 
HIDE User 'line      ( 0 - l/blk )

\ Convert the current line number to an address
HIDE : >laddr    ( baddr -- laddr ) 
   'line @ c/l *  +
;


\   Move the line pointer in a direction, wrapping around
\   and yielding the block adjustment (-1, 0, 1)
HIDE : ~curs ( ladj -- badj )
    'line +!
    'line @  dup  0< if
        drop 
        l/blk 1- 'line !    -1    
    else
        l/blk >= if
            0 'line !       1
        else
                            0
        then
    then
;

\   Set up a move between the current and next line
HIDE : >ln-mov ( baddr -- lpos+1 lpos nch )
    l/blk  'line @ -  1- c/l *  >r         ( baddr ) 
    >laddr  dup c/l + r>         ( dst src n )
;    

\   Delete the current line, shifting others up.
HIDE : ~del ( baddr -- )
    dup >r
    >ln-mov  >r swap r>  cmove
    r>  chars/block + c/l -  c/l  bl  fill  ( blank the end )
;

\   Insert a copy of the current line, shifting others down.
\   No effect on last line.
\   Keeps the same line.
HIDE : ~ins> ( baddr -- )
    >ln-mov cmove>
;

\   Clear the whole line.
HIDE : ~clear-line ( baddr -- )
    >laddr  c/l  bl fill 
;

\   Insert a new line, shifting others down.
HIDE : ~ins ( baddr -- )
    dup >r ~ins> r> ~clear-line 
;

\   Copy part of a line into TIB
HIDE : (~copy) ( laddr n -- )
    >r tib r@ cmove
    tib r@ +  c/l r> -  bl fill
;

\   Copy the current line to TIB.
HIDE : ~copy ( baddr -- )
    >laddr c/l (~copy)
;

\   Paste the current line from TIB.
HIDE : ~paste ( baddr -- )
    >laddr tib swap  c/l cmove
;

\   Duplicate the line and move down without affecting clip.
\   Return buffer adj if we need to go to the next buffer.
HIDE : ~dup ( baddr -- badj )
    
    \ insert and copy line
    ~ins>
    
    \ move down
    1 'line +!
    'line @ l/blk >= if
        0 'line !  1    
    else
        0
    then 
;

\   Split a line at the cursor, shifting others down.
\   Place split part at start of line.
\   On the last line, copies the second half.
\   Returns buffer adj if moving to next buffer.
HIDE : ~split ( baddr -- badj )
    'line @ l/blk 1- = if
        dup >laddr >curs #left (~copy)
    then
    
    dup ~ins>               ( baddr )
    dup >laddr
    ^clear-end  1 ~curs     ( baddr badj )
    
    swap                    ( badj baddr )
    
    >laddr 0 ^bksp-to
;

\   Join a line at the cursor, shifting others up.
\   Take next line and place at cursor.
HIDE : ~join ( baddr -- )
    'line @ l/blk 1- = if
        drop exit
    then
    
    dup  >laddr c/l +      ( baddr nextline )  
    over >laddr 'col @ +    ( baddr nextline curs )
    #left cmove 
    
    1 'line +!  ~del  -1 'line +!
;

\   Flags: result of last command(s)
\
\       $1: content changed, possibly only current line
\       $2: cursor moved OR redraw status
\       $4: redraw block
\       $8: move cursor to upper-left
| User 'fl

| User ovr        ( insert/overwrite flag )

: pause begin key? while key drop repeat  key drop ;
: trace [char] ( emit r@ u. [char] ) emit space .s cr pause ;

\ Editor table
\
\ entries: [ flag | keycode ] | xt
\
\ Every entry accepts 'baddr'


| : !up drop -1 ~curs scr +! ;           
| : !left drop -1 ^curs ~curs scr +! ;     
| : !right drop 1 ^curs ~curs scr +! ;      
| : !down drop 1 ~curs scr +! ;           

| : !block-down 1 scr +! ;
| : !block-up -1 scr +! ;

\   dup; down    
| : !dup-line ~dup scr +! ;               

| : !home >laddr ^home ;                     
| : !end >laddr ^end ;                      

| : !home-line drop 0 'line ! ;                 
| : !end-line drop l/blk 1- 'line ! ;          

\   erase line contents (copying what's deleted)
| : (erase) ( baddr n col ) rot + >laddr swap 2dup (~copy) bl fill ;
| : !erase c/l 0 (erase) ;
\   erase end of line contents
| : !erase-to #left 'col @ (erase) ;
                
\   delete line, no copy
| : !del-line ~del ;

\   insert/overwrite mode   
| : !ins/ovr drop $8000 ovr +! ;      

\   delete char           
| : !del >laddr ^del ;                  

\   delete one char back
| : !bksp >laddr ^bksp ~curs scr +! ;

\   backspace to the previous non-whitespace or beginning of line
\ | : !bksp-to >laddr dup >home ^bksp-to ;

\   Figure out how to tab in a given direction
| : (tab)   ( baddr dir -- laddr tabcol col )
    >r 
    'line @ if
        \ relative to line above
        dup >laddr c/l - 'col @ r> >tab   ( baddr tabcol )
        \ back to our line
        >r >laddr r>        
        'col @              
    else
        >laddr 'col @  dup r>  +tab  swap 
    then
;

| : !tab 
   1 (tab)
   ?do bl over ^char drop loop 
;

| : !untab
  -1 (tab)
    ?do dup ^bksp drop -1 +loop
;

\   paste line
| : !paste ~paste ;
        
\   copy line
| : !copy-line ~copy ;
        
\   enter: 
\       overwrite mode: go to next line at indent of current line
\       insert mode: split line
| : !enter ovr @ if
        >laddr ^home  1 ~curs 
    else 
        ~split  0 'col !
        $6 'fl |!    \ HACK to avoid polluting non-ovr
    then
    scr +!
; 

| : !join ~join ;
        
\   save
| : !save drop flush ;

\   revert
| : !revert drop revert ;

| : !clear chars/block bl fill ; 

\   load the buffer
| : !load intp.window  scr @ load  edit.window ;

| : !exit drop editor.exit ;                     
| : !interpret drop intp.window &11 emit quit ;

| : !refresh drop edit.drawui ;

\ 221=shift bksp
\ 222=shift tab

| create edittab 
    &3   ( ctrl-c copy line )               $0 c, c,  ' !copy-line ,
    &4   ( ctrl-d delete line, no copy )    $5 c, c,  ' !del-line ,
    &8   ( bksp )                           $3 c, c,  ' !bksp ,
    &9   ( tab )                            $3 c, c,  ' !tab ,
    &10  ( ctrl-j join lines )              $7 c, c,  ' !join ,   
    &11  ( ctrl-k clear end of line )       $3 c, c,  ' !erase-to ,   
    &12  ( ctrl-l load )                    $2 c, c,  ' !load ,
    &13  ( enter )                          $2 c, c,  ' !enter ,
    &19  ( ctrl-s save )                    $2 c, c,  ' !save ,
    &22  ( ctrl-v paste line )              $1 c, c,  ' !paste ,
    &152 ( fctn-0 end )                     $2 c, c,  ' !end ,
    &153 ( fctn-1 delete char )             $3 c, c,  ' !del ,
    &154 ( fctn-2 insert/overwrite mode )   $2 c, c,  ' !ins/ovr ,
    &155 ( fctn-3 erase line )              $3 c, c,  ' !erase ,   
    &156 ( fctn-6 to end line )             $2 c, c,  ' !end-line ,
    &157 ( fctn-5 home )                    $2 c, c,  ' !home  ,
    &158 ( fctn-4 to first line )           $A c, c,  ' !home-line ,
    &160 ( fctn-8 dup; down )               $7 c, c,  ' !dup-line ,
    &161 ( fctn-9 exit )                    $0 c, c,  ' !exit ,
    &178 ( ctrl-fctn-l clear )              $7 c, c,  ' !clear ,
    &184 ( ctrl-fctn-r revert )             $6 c, c,  ' !revert ,
    &197 ( ctrl-fctn-4 block down  )        $E c, c,  ' !block-down ,
    &198 ( ctrl-fctn-5 refresh )            $6 c, c,  ' !refresh  ,
    &199 ( ctrl-fctn-6 block up  )          $E c, c,  ' !block-up ,
    &202 ( ctrl-fctn-9 interpret  )         $0 c, c,  ' !interpret ,
    &210 ( fctn-e up  )                     $2 c, c,  ' !up ,
    &211 ( fctn-s left )                    $2 c, c,  ' !left ,
    &212 ( fctn-d right )                   $2 c, c,  ' !right ,
    &213 ( fctn-x down )                    $2 c, c,  ' !down ,
    &222 ( shift-tab )                      $3 c, c,  ' !untab ,
| here edittab - constant editsz

\              01234567890123456789012345678901234567890123456789012345678901234567890123456789
| : menubar s"  C-Save C-F-Revert C-Load C-F4-next C-F6-prev F8-dup C-Del              F9-exit" ;

\ Edit a character (insert or overwrite), moving cursor,
\ possibly to next line or buffer.
| : edit.char  ( ch baddr -- )
    >laddr ^char ~curs ( badj )
    update  scr +!
    $3 'fl |!
;

\ Handle one key for the buffer and update cursor/line/buffer
| : onkey       ( key baddr -- )
    \ if printable, just insert/overwrite
    over &32 &126 within if  
        edit.char  
    else
        \ try for function
        edittab editsz over + swap do
            over  i @ s>b   ( key baddr key flags keycode ) 
            rot = if        ( key baddr flags )
                'fl |!
                i cell+ @  execute  
                unloop drop exit
            else
                drop
            then
        4 +loop
        2drop
    then
;

\ -------------------------------------------------------------------
\   UI for the editor.
\
\   This will be brought up by flipping to text mode 2, vpage 15.
\   (We save the "real" registers/settings and restore them 
\   afterward, so exiting will restore the screen.)
\

\ buffer for saved video state
| User orig-video
| User edit-video
| User in-editor

| : init-editor
    0 orig-video !
    0 edit-video !
    0 in-editor !
;

| : save-video ( ptr -- )
    dup @ 0= if  here over !  #vrs allot  then
    @ vsave 
;

| : editor.exit
    \ restore mode info
    orig-video @ vrestore
    0 in-editor !
    quit   
;

| User 'lastscr
| User 'lastline
| User 'lastcol

\ column for status
| &74 constant #statuscol
| &8 constant #x-border
| &1 constant #y-border
| #y-border l/blk + 1+  constant #y-menu

\ Emit 'n' copies of a character
: emits ( n ch -- )
    swap 0 do 
        dup emit
    loop drop
;

\   Create the interpretation window
| : intp.window
    -1  0 #y-menu 1+ b>s  win!
    1 blink!
;

\   Set up the window for the editor
| : edit.window
    full!
        
    0 blink!    
;

\ Draw the overarching static UI
\
| : edit.drawui

    text2 (mode)  &15 vpage  vreset

    $A1 $7 (vr!)      \ yellow-on-black border
    $F5 $C (vr!)      \ white-on-blue text
    $F0 $D (vr!)      \ blink always on

    edit.window
    
    \ clear whole screen to border
    cls

    \ clear out editor window
    1 blink!
    c/l l/blk b>s  #x-border #y-border b>s  win!
    cls
    
    \ clear out interpret window
    intp.window cls 
    
    \ work in full window normally though
    edit.window
    
    \ draw labels
    #statuscol #y-border                    at-xy  ." SCR"
    #statuscol [ #y-border 2+ ] literal     at-xy  ."  LN"
    #statuscol [ #y-border 4 + ] literal    at-xy  ." COL"
    
    \ draw row numbers    
    l/blk 0 do
        0 i #y-border + at-xy  i #x-border 2- u.r    
    loop
    
    
    \ draw border around editor 
    [ #x-border 1- ] literal 
    [ #y-border 1- ] literal   at-xy
    &250 emit  c/l &243 emits  &249 emit
    
    l/blk 0 do
        i #y-border +            
        [ #x-border 1- ] literal
        over at-xy
        &252 emit
        [ #x-border c/l + ] literal
        swap at-xy
        &252 emit
    loop

    [ #x-border 1- ] literal 
    [ #y-border l/blk + ] literal   at-xy
    &246 emit  c/l &243 emits  &245 emit


    \ draw menu
    0 #y-menu  at-xy  menubar type
    
    \ save editor mode info
    edit-video save-video
    
;

\   Draw status 

| : edit.drawstatus
    0 blink!
    #statuscol [ #y-border 1+ ] literal     at-xy  scr @    3 u.r   
                                                    dirty? [char] * and emit 
    #statuscol [ #y-border 3 + ] literal    at-xy  'line @  3 u.r 
    #statuscol [ #y-border 5 + ] literal    at-xy  'col @   3 u.r
    \ OVR is $8000 or 0
    #statuscol [ #y-border 7 + ] literal    at-xy  ovr @  if ." OVR" else ." INS" then
    
    \ set cursor
    'col @ #x-border +  'line @ #y-border +  at-xy
    1 blink!    
;

\   Draw the given line of the block
| : edit.drawline ( line -- )
    <video limi0
    
    dup  
    c/l *  scr @ block  +  ( line laddr )
      
    #x-border rot #y-border +  
    b>s  xyad@  nip
    c/l cvmove
    
    limi1 video>
;

\   Draw the whole block
| : edit.drawblock ( -- )
    l/blk 0 do
        i edit.drawline
    loop
;

\   Remember last time we updated based on the position ... also fix values
| : edit.lastpos!
    scr @ 'lastscr !
    'line @ 'lastline !
    'col @ 'lastcol !
;

| : edit.update
    
    scr @ 'lastscr @ xor
    if  $C 'fl |!  then
    
    \ did anything change?
    'fl @
    
    \ redraw changed line/block
    dup 4 and if
        edit.drawblock
    else dup 1 and if
        'line @ edit.drawline
        \ if status/cursor changed, likely prev line changed too
        dup 2 and if 'lastline @ edit.drawline then      
    then then
    
    dup 1 and if    \ content changed
        update
        2 or   
    then
    
    dup 8 and if        \ move cursor
        0 'col ! 0 'line !
    then      
    
    2 and if
        edit.drawstatus      \ cursor loc, block #, etc
    then
    
    0 'fl !
    
    edit.lastpos!
;

\ Adjust to viable block first
| : edit.fixblock
    scr @  0 <= if 1 scr !  $2 'fl |! then 
;

\ Main loop of editor.
\
| : (edit)
    \ do most UI work with interrupts enabled, so we
    \ don't miss keystrokes
    edit.window
    edit.fixblock
    edit.drawstatus
    edit.drawblock
    
    begin
        \ handle key buffer, allowing a lot of changes
        \ whilst furiously typing
        key? if
            begin
                key?
            while
                key  scr @ block  onkey
                edit.fixblock
            repeat
    
            edit.update
        then
    again
;

\ Start editor from any mode.  Saves the previous mode.
\
: edit   ( -- )
    decimal
    in-editor @ 0= if
        \ save mode info
        orig-video save-video
        
        \ switch to text mode, but don't clear screen until selecting the page
        edit-video @ ?dup if
            vrestore
        else
            edit.drawui
        then
    
        \ remember last time we updated
        edit.lastpos!
        
        1 in-editor !
    then
    
    (edit)
;

: >edit ( block # -- )
    scr ! edit
;