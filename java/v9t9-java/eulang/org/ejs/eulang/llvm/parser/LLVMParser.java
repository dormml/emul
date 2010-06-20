// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g 2010-06-20 13:25:24

package org.ejs.eulang.llvm.parser;
import org.ejs.eulang.symbols.*;
import org.ejs.eulang.llvm.*;
import org.ejs.eulang.llvm.directives.*;
import org.ejs.eulang.llvm.ops.*;
import org.ejs.eulang.llvm.instrs.*;
import org.ejs.eulang.types.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class LLVMParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEWLINE", "EQUALS", "INT_TYPE", "NAMED_ID", "UNNAMED_ID", "QUOTED_ID", "NUMBER", "CHAR_LITERAL", "STRING_LITERAL", "CSTRING_LITERAL", "DEFINE", "LABEL", "NUMSUFFIX", "SYM_PFX", "NUMBER_SUFFIX", "NAME_SUFFIX", "WS", "SINGLE_COMMENT", "MULTI_COMMENT", "'target'", "'datalayout'", "'triple'", "'type'", "'void'", "'*'", "'{'", "'}'", "'['", "'x'", "']'", "'('", "')'", "','", "'global'", "'constant'", "'addrspace'", "'private'", "'linker_private'", "'internal'", "'available_externally'", "'linkonce'", "'weak'", "'common'", "'appending'", "'extern_weak'", "'linkonce_odr'", "'weak_odr'", "'externally_visible'", "'dllimport'", "'dllexport'", "'zeroinitializer'", "'to'", "'trunc'", "'zext'", "'sext'", "'fptrunc'", "'fpext'", "'fptoui'", "'fptosi'", "'uitofp'", "'sitofp'", "'ptrtoint'", "'inttoptr'", "'bitcast'", "'default'", "'hidden'", "'protected'", "'ccc'", "'fastcc'", "'coldcc'", "'cc 10'", "'cc'", "'zeroext'", "'signext'", "'inreg'", "'byval'", "'sret'", "'noalias'", "'nocapture'", "'nest'", "'alignstack'", "'alwaysinline'", "'inlinehint'", "'noinline'", "'optsize'", "'noreturn'", "'nounwind'", "'readnone'", "'readonly'", "'ssp'", "'sspreq'", "'noredzone'", "'noimplicitfloat'", "'naked'", "':'", "'alloca'", "'store'", "'ret'", "'br'", "'label'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int EQUALS=5;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int STRING_LITERAL=12;
    public static final int T__90=90;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int NUMBER_SUFFIX=18;
    public static final int NUMBER=10;
    public static final int NAMED_ID=7;
    public static final int INT_TYPE=6;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int SYM_PFX=17;
    public static final int WS=20;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int NAME_SUFFIX=19;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int MULTI_COMMENT=22;
    public static final int T__61=61;
    public static final int DEFINE=14;
    public static final int T__60=60;
    public static final int QUOTED_ID=9;
    public static final int NUMSUFFIX=16;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int T__103=103;
    public static final int SINGLE_COMMENT=21;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int NEWLINE=4;
    public static final int CHAR_LITERAL=11;
    public static final int T__36=36;
    public static final int LABEL=15;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int CSTRING_LITERAL=13;
    public static final int UNNAMED_ID=8;

    // delegates
    // delegators


        public LLVMParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LLVMParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return LLVMParser.tokenNames; }
    public String getGrammarFileName() { return "/home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g"; }


        public String getTokenErrorDisplay(Token t) {
            return '\'' + t.getText() + '\'';
        }

        LLParserHelper helper;   
         
        public LLVMParser(TokenStream input, LLParserHelper helper) {
            this(input);
            this.helper = helper;
        }
      


    public static class prog_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prog"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:50:1: prog : toplevelstmts EOF ;
    public final LLVMParser.prog_return prog() throws RecognitionException {
        LLVMParser.prog_return retval = new LLVMParser.prog_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        LLVMParser.toplevelstmts_return toplevelstmts1 = null;


        CommonTree EOF2_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:50:5: ( toplevelstmts EOF )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:50:9: toplevelstmts EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_toplevelstmts_in_prog69);
            toplevelstmts1=toplevelstmts();

            state._fsp--;

            adaptor.addChild(root_0, toplevelstmts1.getTree());
            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_prog71); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prog"

    public static class toplevelstmts_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "toplevelstmts"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:53:1: toplevelstmts : ( directive )* ;
    public final LLVMParser.toplevelstmts_return toplevelstmts() throws RecognitionException {
        LLVMParser.toplevelstmts_return retval = new LLVMParser.toplevelstmts_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.directive_return directive3 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:53:14: ( ( directive )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:53:17: ( directive )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:53:17: ( directive )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NEWLINE||(LA1_0>=NAMED_ID && LA1_0<=QUOTED_ID)||LA1_0==DEFINE||LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:53:17: directive
            	    {
            	    pushFollow(FOLLOW_directive_in_toplevelstmts101);
            	    directive3=directive();

            	    state._fsp--;

            	    adaptor.addChild(root_0, directive3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "toplevelstmts"

    public static class directive_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "directive"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:56:1: directive : ( targetDataLayoutDirective ( NEWLINE | EOF ) | targetTripleDirective ( NEWLINE | EOF ) | typeDefinition ( NEWLINE | EOF ) | globalDataDirective ( NEWLINE | EOF ) | constantDirective ( NEWLINE | EOF ) | defineDirective ( NEWLINE | EOF ) | NEWLINE );
    public final LLVMParser.directive_return directive() throws RecognitionException {
        LLVMParser.directive_return retval = new LLVMParser.directive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set5=null;
        Token set7=null;
        Token set9=null;
        Token set11=null;
        Token set13=null;
        Token set15=null;
        Token NEWLINE16=null;
        LLVMParser.targetDataLayoutDirective_return targetDataLayoutDirective4 = null;

        LLVMParser.targetTripleDirective_return targetTripleDirective6 = null;

        LLVMParser.typeDefinition_return typeDefinition8 = null;

        LLVMParser.globalDataDirective_return globalDataDirective10 = null;

        LLVMParser.constantDirective_return constantDirective12 = null;

        LLVMParser.defineDirective_return defineDirective14 = null;


        CommonTree set5_tree=null;
        CommonTree set7_tree=null;
        CommonTree set9_tree=null;
        CommonTree set11_tree=null;
        CommonTree set13_tree=null;
        CommonTree set15_tree=null;
        CommonTree NEWLINE16_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:56:12: ( targetDataLayoutDirective ( NEWLINE | EOF ) | targetTripleDirective ( NEWLINE | EOF ) | typeDefinition ( NEWLINE | EOF ) | globalDataDirective ( NEWLINE | EOF ) | constantDirective ( NEWLINE | EOF ) | defineDirective ( NEWLINE | EOF ) | NEWLINE )
            int alt2=7;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:56:14: targetDataLayoutDirective ( NEWLINE | EOF )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_targetDataLayoutDirective_in_directive122);
                    targetDataLayoutDirective4=targetDataLayoutDirective();

                    state._fsp--;

                    adaptor.addChild(root_0, targetDataLayoutDirective4.getTree());
                    set5=(Token)input.LT(1);
                    if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                        input.consume();
                        adaptor.addChild(root_0, (CommonTree)adaptor.create(set5));
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:57:5: targetTripleDirective ( NEWLINE | EOF )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_targetTripleDirective_in_directive137);
                    targetTripleDirective6=targetTripleDirective();

                    state._fsp--;

                    adaptor.addChild(root_0, targetTripleDirective6.getTree());
                    set7=(Token)input.LT(1);
                    if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                        input.consume();
                        adaptor.addChild(root_0, (CommonTree)adaptor.create(set7));
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:58:5: typeDefinition ( NEWLINE | EOF )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_typeDefinition_in_directive152);
                    typeDefinition8=typeDefinition();

                    state._fsp--;

                    adaptor.addChild(root_0, typeDefinition8.getTree());
                    set9=(Token)input.LT(1);
                    if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                        input.consume();
                        adaptor.addChild(root_0, (CommonTree)adaptor.create(set9));
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:59:5: globalDataDirective ( NEWLINE | EOF )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_globalDataDirective_in_directive167);
                    globalDataDirective10=globalDataDirective();

                    state._fsp--;

                    adaptor.addChild(root_0, globalDataDirective10.getTree());
                    set11=(Token)input.LT(1);
                    if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                        input.consume();
                        adaptor.addChild(root_0, (CommonTree)adaptor.create(set11));
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:60:5: constantDirective ( NEWLINE | EOF )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_constantDirective_in_directive182);
                    constantDirective12=constantDirective();

                    state._fsp--;

                    adaptor.addChild(root_0, constantDirective12.getTree());
                    set13=(Token)input.LT(1);
                    if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                        input.consume();
                        adaptor.addChild(root_0, (CommonTree)adaptor.create(set13));
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;
                case 6 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:61:5: defineDirective ( NEWLINE | EOF )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_defineDirective_in_directive196);
                    defineDirective14=defineDirective();

                    state._fsp--;

                    adaptor.addChild(root_0, defineDirective14.getTree());
                    set15=(Token)input.LT(1);
                    if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                        input.consume();
                        adaptor.addChild(root_0, (CommonTree)adaptor.create(set15));
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;
                case 7 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:62:5: NEWLINE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NEWLINE16=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_directive210); 
                    NEWLINE16_tree = (CommonTree)adaptor.create(NEWLINE16);
                    adaptor.addChild(root_0, NEWLINE16_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "directive"

    public static class targetDataLayoutDirective_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "targetDataLayoutDirective"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:65:1: targetDataLayoutDirective : 'target' 'datalayout' EQUALS stringLiteral ;
    public final LLVMParser.targetDataLayoutDirective_return targetDataLayoutDirective() throws RecognitionException {
        LLVMParser.targetDataLayoutDirective_return retval = new LLVMParser.targetDataLayoutDirective_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal17=null;
        Token string_literal18=null;
        Token EQUALS19=null;
        LLVMParser.stringLiteral_return stringLiteral20 = null;


        CommonTree string_literal17_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree EQUALS19_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:65:27: ( 'target' 'datalayout' EQUALS stringLiteral )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:65:29: 'target' 'datalayout' EQUALS stringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal17=(Token)match(input,23,FOLLOW_23_in_targetDataLayoutDirective223); 
            string_literal17_tree = (CommonTree)adaptor.create(string_literal17);
            adaptor.addChild(root_0, string_literal17_tree);

            string_literal18=(Token)match(input,24,FOLLOW_24_in_targetDataLayoutDirective225); 
            string_literal18_tree = (CommonTree)adaptor.create(string_literal18);
            adaptor.addChild(root_0, string_literal18_tree);

            EQUALS19=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_targetDataLayoutDirective227); 
            EQUALS19_tree = (CommonTree)adaptor.create(EQUALS19);
            adaptor.addChild(root_0, EQUALS19_tree);

            pushFollow(FOLLOW_stringLiteral_in_targetDataLayoutDirective229);
            stringLiteral20=stringLiteral();

            state._fsp--;

            adaptor.addChild(root_0, stringLiteral20.getTree());
             helper.addTargetDataLayoutDirective((stringLiteral20!=null?stringLiteral20.theText:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "targetDataLayoutDirective"

    public static class targetTripleDirective_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "targetTripleDirective"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:69:1: targetTripleDirective : 'target' 'triple' EQUALS stringLiteral ;
    public final LLVMParser.targetTripleDirective_return targetTripleDirective() throws RecognitionException {
        LLVMParser.targetTripleDirective_return retval = new LLVMParser.targetTripleDirective_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal21=null;
        Token string_literal22=null;
        Token EQUALS23=null;
        LLVMParser.stringLiteral_return stringLiteral24 = null;


        CommonTree string_literal21_tree=null;
        CommonTree string_literal22_tree=null;
        CommonTree EQUALS23_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:69:23: ( 'target' 'triple' EQUALS stringLiteral )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:69:25: 'target' 'triple' EQUALS stringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal21=(Token)match(input,23,FOLLOW_23_in_targetTripleDirective245); 
            string_literal21_tree = (CommonTree)adaptor.create(string_literal21);
            adaptor.addChild(root_0, string_literal21_tree);

            string_literal22=(Token)match(input,25,FOLLOW_25_in_targetTripleDirective247); 
            string_literal22_tree = (CommonTree)adaptor.create(string_literal22);
            adaptor.addChild(root_0, string_literal22_tree);

            EQUALS23=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_targetTripleDirective249); 
            EQUALS23_tree = (CommonTree)adaptor.create(EQUALS23);
            adaptor.addChild(root_0, EQUALS23_tree);

            pushFollow(FOLLOW_stringLiteral_in_targetTripleDirective251);
            stringLiteral24=stringLiteral();

            state._fsp--;

            adaptor.addChild(root_0, stringLiteral24.getTree());
             helper.addTargetTripleDirective((stringLiteral24!=null?stringLiteral24.theText:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "targetTripleDirective"

    public static class typeDefinition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeDefinition"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:73:1: typeDefinition : identifier EQUALS 'type' type ;
    public final LLVMParser.typeDefinition_return typeDefinition() throws RecognitionException {
        LLVMParser.typeDefinition_return retval = new LLVMParser.typeDefinition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS26=null;
        Token string_literal27=null;
        LLVMParser.identifier_return identifier25 = null;

        LLVMParser.type_return type28 = null;


        CommonTree EQUALS26_tree=null;
        CommonTree string_literal27_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:73:16: ( identifier EQUALS 'type' type )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:73:18: identifier EQUALS 'type' type
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_typeDefinition266);
            identifier25=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier25.getTree());
            EQUALS26=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_typeDefinition268); 
            EQUALS26_tree = (CommonTree)adaptor.create(EQUALS26);
            adaptor.addChild(root_0, EQUALS26_tree);

            string_literal27=(Token)match(input,26,FOLLOW_26_in_typeDefinition270); 
            string_literal27_tree = (CommonTree)adaptor.create(string_literal27);
            adaptor.addChild(root_0, string_literal27_tree);

            pushFollow(FOLLOW_type_in_typeDefinition274);
            type28=type();

            state._fsp--;

            adaptor.addChild(root_0, type28.getTree());
             
              	helper.addNewType((identifier25!=null?identifier25.theId:null), (type28!=null?type28.theType:null)); 
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeDefinition"

    public static class type_return extends ParserRuleReturnScope {
        public LLType theType;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:80:1: type returns [LLType theType] : (t0= inttype | t1= structtype | t2= arraytype | 'void' | t3= symboltype ) ( '*' )* ( paramstype )? ;
    public final LLVMParser.type_return type() throws RecognitionException {
        LLVMParser.type_return retval = new LLVMParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal29=null;
        Token char_literal30=null;
        LLVMParser.inttype_return t0 = null;

        LLVMParser.structtype_return t1 = null;

        LLVMParser.arraytype_return t2 = null;

        LLVMParser.symboltype_return t3 = null;

        LLVMParser.paramstype_return paramstype31 = null;


        CommonTree string_literal29_tree=null;
        CommonTree char_literal30_tree=null;


        	  	// ensure we recognize temp symbols like percent 0 as pointing
        	  	// to types rather than variables
        		helper.inTypeContext++;
            
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:92:5: ( (t0= inttype | t1= structtype | t2= arraytype | 'void' | t3= symboltype ) ( '*' )* ( paramstype )? )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:93:2: (t0= inttype | t1= structtype | t2= arraytype | 'void' | t3= symboltype ) ( '*' )* ( paramstype )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:93:2: (t0= inttype | t1= structtype | t2= arraytype | 'void' | t3= symboltype )
            int alt3=5;
            switch ( input.LA(1) ) {
            case INT_TYPE:
                {
                alt3=1;
                }
                break;
            case 29:
                {
                alt3=2;
                }
                break;
            case 31:
                {
                alt3=3;
                }
                break;
            case 27:
                {
                alt3=4;
                }
                break;
            case NAMED_ID:
            case UNNAMED_ID:
            case QUOTED_ID:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:93:5: t0= inttype
                    {
                    pushFollow(FOLLOW_inttype_in_type327);
                    t0=inttype();

                    state._fsp--;

                    adaptor.addChild(root_0, t0.getTree());
                     retval.theType = (t0!=null?t0.theType:null); 

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:94:5: t1= structtype
                    {
                    pushFollow(FOLLOW_structtype_in_type338);
                    t1=structtype();

                    state._fsp--;

                    adaptor.addChild(root_0, t1.getTree());
                     retval.theType = (t1!=null?t1.theType:null); 

                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:95:5: t2= arraytype
                    {
                    pushFollow(FOLLOW_arraytype_in_type348);
                    t2=arraytype();

                    state._fsp--;

                    adaptor.addChild(root_0, t2.getTree());
                     retval.theType = (t2!=null?t2.theType:null); 

                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:96:5: 'void'
                    {
                    string_literal29=(Token)match(input,27,FOLLOW_27_in_type356); 
                    string_literal29_tree = (CommonTree)adaptor.create(string_literal29);
                    adaptor.addChild(root_0, string_literal29_tree);

                     retval.theType = helper.typeEngine.VOID; 

                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:97:5: t3= symboltype
                    {
                    pushFollow(FOLLOW_symboltype_in_type373);
                    t3=symboltype();

                    state._fsp--;

                    adaptor.addChild(root_0, t3.getTree());
                     retval.theType = (t3!=null?t3.theType:null); 

                    }
                    break;

            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:100:2: ( '*' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==28) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:100:4: '*'
            	    {
            	    char_literal30=(Token)match(input,28,FOLLOW_28_in_type390); 
            	    char_literal30_tree = (CommonTree)adaptor.create(char_literal30);
            	    adaptor.addChild(root_0, char_literal30_tree);

            	     retval.theType = helper.addPointerType(retval.theType); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:102:2: ( paramstype )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==34) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:102:3: paramstype
                    {
                    pushFollow(FOLLOW_paramstype_in_type402);
                    paramstype31=paramstype();

                    state._fsp--;

                    adaptor.addChild(root_0, paramstype31.getTree());
                     retval.theType = helper.addCodeType(retval.theType, (paramstype31!=null?paramstype31.theArgs:null)); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


                // done 
                  helper.inTypeContext--;
                
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class inttype_return extends ParserRuleReturnScope {
        public LLType theType;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inttype"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:106:1: inttype returns [LLType theType] : INT_TYPE ;
    public final LLVMParser.inttype_return inttype() throws RecognitionException {
        LLVMParser.inttype_return retval = new LLVMParser.inttype_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT_TYPE32=null;

        CommonTree INT_TYPE32_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:106:34: ( INT_TYPE )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:106:36: INT_TYPE
            {
            root_0 = (CommonTree)adaptor.nil();

            INT_TYPE32=(Token)match(input,INT_TYPE,FOLLOW_INT_TYPE_in_inttype424); 
            INT_TYPE32_tree = (CommonTree)adaptor.create(INT_TYPE32);
            adaptor.addChild(root_0, INT_TYPE32_tree);

             retval.theType = helper.addIntType((INT_TYPE32!=null?INT_TYPE32.getText():null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inttype"

    public static class structtype_return extends ParserRuleReturnScope {
        public LLType theType;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structtype"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:110:1: structtype returns [LLType theType] : '{' typeList '}' ;
    public final LLVMParser.structtype_return structtype() throws RecognitionException {
        LLVMParser.structtype_return retval = new LLVMParser.structtype_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal33=null;
        Token char_literal35=null;
        LLVMParser.typeList_return typeList34 = null;


        CommonTree char_literal33_tree=null;
        CommonTree char_literal35_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:110:38: ( '{' typeList '}' )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:110:40: '{' typeList '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal33=(Token)match(input,29,FOLLOW_29_in_structtype443); 
            char_literal33_tree = (CommonTree)adaptor.create(char_literal33);
            adaptor.addChild(root_0, char_literal33_tree);

            pushFollow(FOLLOW_typeList_in_structtype445);
            typeList34=typeList();

            state._fsp--;

            adaptor.addChild(root_0, typeList34.getTree());
            char_literal35=(Token)match(input,30,FOLLOW_30_in_structtype447); 
            char_literal35_tree = (CommonTree)adaptor.create(char_literal35);
            adaptor.addChild(root_0, char_literal35_tree);


            		retval.theType = helper.addTupleType((typeList34!=null?typeList34.theTypes:null)); 
            	

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "structtype"

    public static class arraytype_return extends ParserRuleReturnScope {
        public LLType theType;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arraytype"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:116:1: arraytype returns [LLType theType] : '[' number 'x' type ']' ;
    public final LLVMParser.arraytype_return arraytype() throws RecognitionException {
        LLVMParser.arraytype_return retval = new LLVMParser.arraytype_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal36=null;
        Token char_literal38=null;
        Token char_literal40=null;
        LLVMParser.number_return number37 = null;

        LLVMParser.type_return type39 = null;


        CommonTree char_literal36_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree char_literal40_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:116:36: ( '[' number 'x' type ']' )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:116:39: '[' number 'x' type ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal36=(Token)match(input,31,FOLLOW_31_in_arraytype468); 
            char_literal36_tree = (CommonTree)adaptor.create(char_literal36);
            adaptor.addChild(root_0, char_literal36_tree);

            pushFollow(FOLLOW_number_in_arraytype470);
            number37=number();

            state._fsp--;

            adaptor.addChild(root_0, number37.getTree());
            char_literal38=(Token)match(input,32,FOLLOW_32_in_arraytype472); 
            char_literal38_tree = (CommonTree)adaptor.create(char_literal38);
            adaptor.addChild(root_0, char_literal38_tree);

            pushFollow(FOLLOW_type_in_arraytype474);
            type39=type();

            state._fsp--;

            adaptor.addChild(root_0, type39.getTree());
            char_literal40=(Token)match(input,33,FOLLOW_33_in_arraytype476); 
            char_literal40_tree = (CommonTree)adaptor.create(char_literal40);
            adaptor.addChild(root_0, char_literal40_tree);

             retval.theType = helper.addArrayType((number37!=null?number37.value:0), (type39!=null?type39.theType:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arraytype"

    public static class paramstype_return extends ParserRuleReturnScope {
        public LLType[] theArgs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "paramstype"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:120:1: paramstype returns [LLType[] theArgs] : '(' typeList ')' ;
    public final LLVMParser.paramstype_return paramstype() throws RecognitionException {
        LLVMParser.paramstype_return retval = new LLVMParser.paramstype_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal41=null;
        Token char_literal43=null;
        LLVMParser.typeList_return typeList42 = null;


        CommonTree char_literal41_tree=null;
        CommonTree char_literal43_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:120:40: ( '(' typeList ')' )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:120:42: '(' typeList ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal41=(Token)match(input,34,FOLLOW_34_in_paramstype494); 
            char_literal41_tree = (CommonTree)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);

            pushFollow(FOLLOW_typeList_in_paramstype496);
            typeList42=typeList();

            state._fsp--;

            adaptor.addChild(root_0, typeList42.getTree());
            char_literal43=(Token)match(input,35,FOLLOW_35_in_paramstype498); 
            char_literal43_tree = (CommonTree)adaptor.create(char_literal43);
            adaptor.addChild(root_0, char_literal43_tree);

             retval.theArgs = (typeList42!=null?typeList42.theTypes:null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "paramstype"

    public static class typeList_return extends ParserRuleReturnScope {
        public LLType[] theTypes;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeList"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:124:1: typeList returns [LLType[] theTypes] : (t= type ( ',' u= type )* )? ;
    public final LLVMParser.typeList_return typeList() throws RecognitionException {
        LLVMParser.typeList_return retval = new LLVMParser.typeList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal44=null;
        LLVMParser.type_return t = null;

        LLVMParser.type_return u = null;


        CommonTree char_literal44_tree=null;


            List<LLType> types = new ArrayList<LLType>();
          
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:133:3: ( (t= type ( ',' u= type )* )? )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:133:5: (t= type ( ',' u= type )* )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:133:5: (t= type ( ',' u= type )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=INT_TYPE && LA7_0<=QUOTED_ID)||LA7_0==27||LA7_0==29||LA7_0==31) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:133:6: t= type ( ',' u= type )*
                    {
                    pushFollow(FOLLOW_type_in_typeList540);
                    t=type();

                    state._fsp--;

                    adaptor.addChild(root_0, t.getTree());
                     types.add((t!=null?t.theType:null)); 
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:134:7: ( ',' u= type )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==36) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:134:8: ',' u= type
                    	    {
                    	    char_literal44=(Token)match(input,36,FOLLOW_36_in_typeList558); 
                    	    char_literal44_tree = (CommonTree)adaptor.create(char_literal44);
                    	    adaptor.addChild(root_0, char_literal44_tree);

                    	    pushFollow(FOLLOW_type_in_typeList562);
                    	    u=type();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, u.getTree());
                    	     types.add((u!=null?u.theType:null)); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


              retval.theTypes = types.toArray(new LLType[types.size()]);
              
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeList"

    public static class symboltype_return extends ParserRuleReturnScope {
        public LLType theType;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "symboltype"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:139:1: symboltype returns [LLType theType] : identifier ;
    public final LLVMParser.symboltype_return symboltype() throws RecognitionException {
        LLVMParser.symboltype_return retval = new LLVMParser.symboltype_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.identifier_return identifier45 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:139:37: ( identifier )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:139:39: identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_symboltype604);
            identifier45=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier45.getTree());
             retval.theType = helper.findOrForwardNameType((identifier45!=null?identifier45.theId:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "symboltype"

    public static class globalDataDirective_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "globalDataDirective"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:143:1: globalDataDirective : identifier EQUALS ( linkage )? 'global' typedconstant ;
    public final LLVMParser.globalDataDirective_return globalDataDirective() throws RecognitionException {
        LLVMParser.globalDataDirective_return retval = new LLVMParser.globalDataDirective_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS47=null;
        Token string_literal49=null;
        LLVMParser.identifier_return identifier46 = null;

        LLVMParser.linkage_return linkage48 = null;

        LLVMParser.typedconstant_return typedconstant50 = null;


        CommonTree EQUALS47_tree=null;
        CommonTree string_literal49_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:143:21: ( identifier EQUALS ( linkage )? 'global' typedconstant )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:143:23: identifier EQUALS ( linkage )? 'global' typedconstant
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_globalDataDirective618);
            identifier46=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier46.getTree());
            EQUALS47=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_globalDataDirective620); 
            EQUALS47_tree = (CommonTree)adaptor.create(EQUALS47);
            adaptor.addChild(root_0, EQUALS47_tree);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:143:41: ( linkage )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=40 && LA8_0<=53)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:143:41: linkage
                    {
                    pushFollow(FOLLOW_linkage_in_globalDataDirective622);
                    linkage48=linkage();

                    state._fsp--;

                    adaptor.addChild(root_0, linkage48.getTree());

                    }
                    break;

            }

            string_literal49=(Token)match(input,37,FOLLOW_37_in_globalDataDirective625); 
            string_literal49_tree = (CommonTree)adaptor.create(string_literal49);
            adaptor.addChild(root_0, string_literal49_tree);

            pushFollow(FOLLOW_typedconstant_in_globalDataDirective627);
            typedconstant50=typedconstant();

            state._fsp--;

            adaptor.addChild(root_0, typedconstant50.getTree());
             helper.addGlobalDataDirective((identifier46!=null?identifier46.theId:null), (linkage48!=null?linkage48.value:null), (typedconstant50!=null?typedconstant50.op:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "globalDataDirective"

    public static class constantDirective_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constantDirective"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:147:1: constantDirective : identifier EQUALS ( addrspace )? 'constant' typedconstant ;
    public final LLVMParser.constantDirective_return constantDirective() throws RecognitionException {
        LLVMParser.constantDirective_return retval = new LLVMParser.constantDirective_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS52=null;
        Token string_literal54=null;
        LLVMParser.identifier_return identifier51 = null;

        LLVMParser.addrspace_return addrspace53 = null;

        LLVMParser.typedconstant_return typedconstant55 = null;


        CommonTree EQUALS52_tree=null;
        CommonTree string_literal54_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:147:19: ( identifier EQUALS ( addrspace )? 'constant' typedconstant )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:147:21: identifier EQUALS ( addrspace )? 'constant' typedconstant
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_constantDirective641);
            identifier51=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier51.getTree());
            EQUALS52=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_constantDirective643); 
            EQUALS52_tree = (CommonTree)adaptor.create(EQUALS52);
            adaptor.addChild(root_0, EQUALS52_tree);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:147:39: ( addrspace )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==39) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:147:39: addrspace
                    {
                    pushFollow(FOLLOW_addrspace_in_constantDirective645);
                    addrspace53=addrspace();

                    state._fsp--;

                    adaptor.addChild(root_0, addrspace53.getTree());

                    }
                    break;

            }

            string_literal54=(Token)match(input,38,FOLLOW_38_in_constantDirective648); 
            string_literal54_tree = (CommonTree)adaptor.create(string_literal54);
            adaptor.addChild(root_0, string_literal54_tree);

            pushFollow(FOLLOW_typedconstant_in_constantDirective650);
            typedconstant55=typedconstant();

            state._fsp--;

            adaptor.addChild(root_0, typedconstant55.getTree());
             helper.addConstantDirective((identifier51!=null?identifier51.theId:null), (addrspace53!=null?addrspace53.value:0), (typedconstant55!=null?typedconstant55.op:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constantDirective"

    public static class addrspace_return extends ParserRuleReturnScope {
        public int value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addrspace"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:151:1: addrspace returns [ int value ] : 'addrspace' '(' number ')' ;
    public final LLVMParser.addrspace_return addrspace() throws RecognitionException {
        LLVMParser.addrspace_return retval = new LLVMParser.addrspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal56=null;
        Token char_literal57=null;
        Token char_literal59=null;
        LLVMParser.number_return number58 = null;


        CommonTree string_literal56_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree char_literal59_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:151:33: ( 'addrspace' '(' number ')' )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:151:35: 'addrspace' '(' number ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal56=(Token)match(input,39,FOLLOW_39_in_addrspace671); 
            string_literal56_tree = (CommonTree)adaptor.create(string_literal56);
            adaptor.addChild(root_0, string_literal56_tree);

            char_literal57=(Token)match(input,34,FOLLOW_34_in_addrspace673); 
            char_literal57_tree = (CommonTree)adaptor.create(char_literal57);
            adaptor.addChild(root_0, char_literal57_tree);

            pushFollow(FOLLOW_number_in_addrspace675);
            number58=number();

            state._fsp--;

            adaptor.addChild(root_0, number58.getTree());
            char_literal59=(Token)match(input,35,FOLLOW_35_in_addrspace677); 
            char_literal59_tree = (CommonTree)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);

             retval.value = (number58!=null?number58.value:0); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addrspace"

    public static class linkage_return extends ParserRuleReturnScope {
        public LLLinkage value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "linkage"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:154:1: linkage returns [ LLLinkage value ] : ( 'private' | 'linker_private' | 'internal' | 'available_externally' | 'linkonce' | 'weak' | 'common' | 'appending' | 'extern_weak' | 'linkonce_odr' | 'weak_odr' | 'externally_visible' | 'dllimport' | 'dllexport' ) ;
    public final LLVMParser.linkage_return linkage() throws RecognitionException {
        LLVMParser.linkage_return retval = new LLVMParser.linkage_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set60=null;

        CommonTree set60_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:154:37: ( ( 'private' | 'linker_private' | 'internal' | 'available_externally' | 'linkonce' | 'weak' | 'common' | 'appending' | 'extern_weak' | 'linkonce_odr' | 'weak_odr' | 'externally_visible' | 'dllimport' | 'dllexport' ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:154:39: ( 'private' | 'linker_private' | 'internal' | 'available_externally' | 'linkonce' | 'weak' | 'common' | 'appending' | 'extern_weak' | 'linkonce_odr' | 'weak_odr' | 'externally_visible' | 'dllimport' | 'dllexport' )
            {
            root_0 = (CommonTree)adaptor.nil();

            set60=(Token)input.LT(1);
            if ( (input.LA(1)>=40 && input.LA(1)<=53) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set60));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             retval.value = LLLinkage.getForToken(input.toString(retval.start,input.LT(-1))); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "linkage"

    public static class typedconstant_return extends ParserRuleReturnScope {
        public LLOperand op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typedconstant"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:160:1: typedconstant returns [ LLOperand op ] : type ( number | charconst | stringconst | structconst | arrayconst | symbolconst | 'zeroinitializer' | constcastexpr ) ;
    public final LLVMParser.typedconstant_return typedconstant() throws RecognitionException {
        LLVMParser.typedconstant_return retval = new LLVMParser.typedconstant_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal68=null;
        LLVMParser.type_return type61 = null;

        LLVMParser.number_return number62 = null;

        LLVMParser.charconst_return charconst63 = null;

        LLVMParser.stringconst_return stringconst64 = null;

        LLVMParser.structconst_return structconst65 = null;

        LLVMParser.arrayconst_return arrayconst66 = null;

        LLVMParser.symbolconst_return symbolconst67 = null;

        LLVMParser.constcastexpr_return constcastexpr69 = null;


        CommonTree string_literal68_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:160:40: ( type ( number | charconst | stringconst | structconst | arrayconst | symbolconst | 'zeroinitializer' | constcastexpr ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:160:42: type ( number | charconst | stringconst | structconst | arrayconst | symbolconst | 'zeroinitializer' | constcastexpr )
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_typedconstant780);
            type61=type();

            state._fsp--;

            adaptor.addChild(root_0, type61.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:161:2: ( number | charconst | stringconst | structconst | arrayconst | symbolconst | 'zeroinitializer' | constcastexpr )
            int alt10=8;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt10=1;
                }
                break;
            case CHAR_LITERAL:
                {
                alt10=2;
                }
                break;
            case CSTRING_LITERAL:
                {
                alt10=3;
                }
                break;
            case 29:
                {
                alt10=4;
                }
                break;
            case 31:
                {
                alt10=5;
                }
                break;
            case NAMED_ID:
            case UNNAMED_ID:
            case QUOTED_ID:
                {
                alt10=6;
                }
                break;
            case 54:
                {
                alt10=7;
                }
                break;
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                {
                alt10=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:161:5: number
                    {
                    pushFollow(FOLLOW_number_in_typedconstant786);
                    number62=number();

                    state._fsp--;

                    adaptor.addChild(root_0, number62.getTree());
                     retval.op = new LLConstOp((type61!=null?type61.theType:null), (number62!=null?number62.value:0)); 

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:162:4: charconst
                    {
                    pushFollow(FOLLOW_charconst_in_typedconstant793);
                    charconst63=charconst();

                    state._fsp--;

                    adaptor.addChild(root_0, charconst63.getTree());
                     retval.op = new LLConstOp((type61!=null?type61.theType:null), (int)(charconst63!=null?charconst63.value:0)); 

                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:163:4: stringconst
                    {
                    pushFollow(FOLLOW_stringconst_in_typedconstant800);
                    stringconst64=stringconst();

                    state._fsp--;

                    adaptor.addChild(root_0, stringconst64.getTree());
                     retval.op = new LLStringLitOp((LLArrayType)(type61!=null?type61.theType:null), (stringconst64!=null?stringconst64.value:null)); 

                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:164:4: structconst
                    {
                    pushFollow(FOLLOW_structconst_in_typedconstant807);
                    structconst65=structconst();

                    state._fsp--;

                    adaptor.addChild(root_0, structconst65.getTree());
                     retval.op = new LLStructOp((LLAggregateType)(type61!=null?type61.theType:null), (structconst65!=null?structconst65.values:null)); 

                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:165:4: arrayconst
                    {
                    pushFollow(FOLLOW_arrayconst_in_typedconstant814);
                    arrayconst66=arrayconst();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayconst66.getTree());
                     retval.op = new LLArrayOp((LLArrayType)(type61!=null?type61.theType:null), (arrayconst66!=null?arrayconst66.values:null)); 

                    }
                    break;
                case 6 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:166:4: symbolconst
                    {
                    pushFollow(FOLLOW_symbolconst_in_typedconstant822);
                    symbolconst67=symbolconst();

                    state._fsp--;

                    adaptor.addChild(root_0, symbolconst67.getTree());
                     retval.op = helper.getSymbolOp((symbolconst67!=null?symbolconst67.theId:null), (symbolconst67!=null?symbolconst67.theSymbol:null)); 

                    }
                    break;
                case 7 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:167:4: 'zeroinitializer'
                    {
                    string_literal68=(Token)match(input,54,FOLLOW_54_in_typedconstant830); 
                    string_literal68_tree = (CommonTree)adaptor.create(string_literal68);
                    adaptor.addChild(root_0, string_literal68_tree);

                     retval.op = new LLZeroInitOp((type61!=null?type61.theType:null)); 

                    }
                    break;
                case 8 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:168:4: constcastexpr
                    {
                    pushFollow(FOLLOW_constcastexpr_in_typedconstant838);
                    constcastexpr69=constcastexpr();

                    state._fsp--;

                    adaptor.addChild(root_0, constcastexpr69.getTree());
                     retval.op = (constcastexpr69!=null?constcastexpr69.op:null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typedconstant"

    public static class constcastexpr_return extends ParserRuleReturnScope {
        public LLOperand op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constcastexpr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:172:1: constcastexpr returns [ LLOperand op ] : casttype '(' typedconstant 'to' type ')' ;
    public final LLVMParser.constcastexpr_return constcastexpr() throws RecognitionException {
        LLVMParser.constcastexpr_return retval = new LLVMParser.constcastexpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal71=null;
        Token string_literal73=null;
        Token char_literal75=null;
        LLVMParser.casttype_return casttype70 = null;

        LLVMParser.typedconstant_return typedconstant72 = null;

        LLVMParser.type_return type74 = null;


        CommonTree char_literal71_tree=null;
        CommonTree string_literal73_tree=null;
        CommonTree char_literal75_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:172:40: ( casttype '(' typedconstant 'to' type ')' )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:172:42: casttype '(' typedconstant 'to' type ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_casttype_in_constcastexpr859);
            casttype70=casttype();

            state._fsp--;

            adaptor.addChild(root_0, casttype70.getTree());
            char_literal71=(Token)match(input,34,FOLLOW_34_in_constcastexpr861); 
            char_literal71_tree = (CommonTree)adaptor.create(char_literal71);
            adaptor.addChild(root_0, char_literal71_tree);

            pushFollow(FOLLOW_typedconstant_in_constcastexpr863);
            typedconstant72=typedconstant();

            state._fsp--;

            adaptor.addChild(root_0, typedconstant72.getTree());
            string_literal73=(Token)match(input,55,FOLLOW_55_in_constcastexpr865); 
            string_literal73_tree = (CommonTree)adaptor.create(string_literal73);
            adaptor.addChild(root_0, string_literal73_tree);

            pushFollow(FOLLOW_type_in_constcastexpr867);
            type74=type();

            state._fsp--;

            adaptor.addChild(root_0, type74.getTree());
            char_literal75=(Token)match(input,35,FOLLOW_35_in_constcastexpr869); 
            char_literal75_tree = (CommonTree)adaptor.create(char_literal75);
            adaptor.addChild(root_0, char_literal75_tree);


                retval.op = new LLCastOp((casttype70!=null?casttype70.cast:null), (type74!=null?type74.theType:null), (typedconstant72!=null?typedconstant72.op:null));
                

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constcastexpr"

    public static class casttype_return extends ParserRuleReturnScope {
        public ECast cast;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "casttype"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:178:1: casttype returns [ ECast cast ] : ( 'trunc' | 'zext' | 'sext' | 'fptrunc' | 'fpext' | 'fptoui' | 'fptosi' | 'uitofp' | 'sitofp' | 'ptrtoint' | 'inttoptr' | 'bitcast' ) ;
    public final LLVMParser.casttype_return casttype() throws RecognitionException {
        LLVMParser.casttype_return retval = new LLVMParser.casttype_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal76=null;
        Token string_literal77=null;
        Token string_literal78=null;
        Token string_literal79=null;
        Token string_literal80=null;
        Token string_literal81=null;
        Token string_literal82=null;
        Token string_literal83=null;
        Token string_literal84=null;
        Token string_literal85=null;
        Token string_literal86=null;
        Token string_literal87=null;

        CommonTree string_literal76_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree string_literal78_tree=null;
        CommonTree string_literal79_tree=null;
        CommonTree string_literal80_tree=null;
        CommonTree string_literal81_tree=null;
        CommonTree string_literal82_tree=null;
        CommonTree string_literal83_tree=null;
        CommonTree string_literal84_tree=null;
        CommonTree string_literal85_tree=null;
        CommonTree string_literal86_tree=null;
        CommonTree string_literal87_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:178:33: ( ( 'trunc' | 'zext' | 'sext' | 'fptrunc' | 'fpext' | 'fptoui' | 'fptosi' | 'uitofp' | 'sitofp' | 'ptrtoint' | 'inttoptr' | 'bitcast' ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:179:3: ( 'trunc' | 'zext' | 'sext' | 'fptrunc' | 'fpext' | 'fptoui' | 'fptosi' | 'uitofp' | 'sitofp' | 'ptrtoint' | 'inttoptr' | 'bitcast' )
            {
            root_0 = (CommonTree)adaptor.nil();


              ECast cast = null;
              
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:182:3: ( 'trunc' | 'zext' | 'sext' | 'fptrunc' | 'fpext' | 'fptoui' | 'fptosi' | 'uitofp' | 'sitofp' | 'ptrtoint' | 'inttoptr' | 'bitcast' )
            int alt11=12;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt11=1;
                }
                break;
            case 57:
                {
                alt11=2;
                }
                break;
            case 58:
                {
                alt11=3;
                }
                break;
            case 59:
                {
                alt11=4;
                }
                break;
            case 60:
                {
                alt11=5;
                }
                break;
            case 61:
                {
                alt11=6;
                }
                break;
            case 62:
                {
                alt11=7;
                }
                break;
            case 63:
                {
                alt11=8;
                }
                break;
            case 64:
                {
                alt11=9;
                }
                break;
            case 65:
                {
                alt11=10;
                }
                break;
            case 66:
                {
                alt11=11;
                }
                break;
            case 67:
                {
                alt11=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:182:5: 'trunc'
                    {
                    string_literal76=(Token)match(input,56,FOLLOW_56_in_casttype907); 
                    string_literal76_tree = (CommonTree)adaptor.create(string_literal76);
                    adaptor.addChild(root_0, string_literal76_tree);

                     cast=ECast.TRUNC; 

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:183:5: 'zext'
                    {
                    string_literal77=(Token)match(input,57,FOLLOW_57_in_casttype915); 
                    string_literal77_tree = (CommonTree)adaptor.create(string_literal77);
                    adaptor.addChild(root_0, string_literal77_tree);

                     cast=ECast.ZEXT; 

                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:184:5: 'sext'
                    {
                    string_literal78=(Token)match(input,58,FOLLOW_58_in_casttype923); 
                    string_literal78_tree = (CommonTree)adaptor.create(string_literal78);
                    adaptor.addChild(root_0, string_literal78_tree);

                     cast=ECast.SEXT; 

                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:185:5: 'fptrunc'
                    {
                    string_literal79=(Token)match(input,59,FOLLOW_59_in_casttype931); 
                    string_literal79_tree = (CommonTree)adaptor.create(string_literal79);
                    adaptor.addChild(root_0, string_literal79_tree);

                     cast=ECast.FPTRUNC; 

                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:186:5: 'fpext'
                    {
                    string_literal80=(Token)match(input,60,FOLLOW_60_in_casttype939); 
                    string_literal80_tree = (CommonTree)adaptor.create(string_literal80);
                    adaptor.addChild(root_0, string_literal80_tree);

                     cast=ECast.FPEXT; 

                    }
                    break;
                case 6 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:187:5: 'fptoui'
                    {
                    string_literal81=(Token)match(input,61,FOLLOW_61_in_casttype947); 
                    string_literal81_tree = (CommonTree)adaptor.create(string_literal81);
                    adaptor.addChild(root_0, string_literal81_tree);

                     cast=ECast.FPTOUI; 

                    }
                    break;
                case 7 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:188:5: 'fptosi'
                    {
                    string_literal82=(Token)match(input,62,FOLLOW_62_in_casttype955); 
                    string_literal82_tree = (CommonTree)adaptor.create(string_literal82);
                    adaptor.addChild(root_0, string_literal82_tree);

                     cast=ECast.FPTOSI; 

                    }
                    break;
                case 8 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:189:5: 'uitofp'
                    {
                    string_literal83=(Token)match(input,63,FOLLOW_63_in_casttype963); 
                    string_literal83_tree = (CommonTree)adaptor.create(string_literal83);
                    adaptor.addChild(root_0, string_literal83_tree);

                     cast=ECast.UITOFP; 

                    }
                    break;
                case 9 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:190:5: 'sitofp'
                    {
                    string_literal84=(Token)match(input,64,FOLLOW_64_in_casttype971); 
                    string_literal84_tree = (CommonTree)adaptor.create(string_literal84);
                    adaptor.addChild(root_0, string_literal84_tree);

                     cast=ECast.SITOFP; 

                    }
                    break;
                case 10 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:191:5: 'ptrtoint'
                    {
                    string_literal85=(Token)match(input,65,FOLLOW_65_in_casttype979); 
                    string_literal85_tree = (CommonTree)adaptor.create(string_literal85);
                    adaptor.addChild(root_0, string_literal85_tree);

                     cast=ECast.PTRTOINT; 

                    }
                    break;
                case 11 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:192:5: 'inttoptr'
                    {
                    string_literal86=(Token)match(input,66,FOLLOW_66_in_casttype988); 
                    string_literal86_tree = (CommonTree)adaptor.create(string_literal86);
                    adaptor.addChild(root_0, string_literal86_tree);

                     cast=ECast.INTTOPTR; 

                    }
                    break;
                case 12 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:193:5: 'bitcast'
                    {
                    string_literal87=(Token)match(input,67,FOLLOW_67_in_casttype996); 
                    string_literal87_tree = (CommonTree)adaptor.create(string_literal87);
                    adaptor.addChild(root_0, string_literal87_tree);

                     cast=ECast.BITCAST; 

                    }
                    break;

            }


              retval.cast = cast;
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "casttype"

    public static class symbolconst_return extends ParserRuleReturnScope {
        public String theId;
        public ISymbol theSymbol;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "symbolconst"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:200:1: symbolconst returns [ String theId, ISymbol theSymbol ] : identifier ;
    public final LLVMParser.symbolconst_return symbolconst() throws RecognitionException {
        LLVMParser.symbolconst_return retval = new LLVMParser.symbolconst_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.identifier_return identifier88 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:200:57: ( identifier )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:201:3: identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_symbolconst1025);
            identifier88=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier88.getTree());
             retval.theSymbol = helper.findSymbol((identifier88!=null?identifier88.theId:null)); retval.theId = (identifier88!=null?identifier88.theId:null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "symbolconst"

    public static class charconst_return extends ParserRuleReturnScope {
        public char value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "charconst"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:205:1: charconst returns [ char value ] : charLiteral ;
    public final LLVMParser.charconst_return charconst() throws RecognitionException {
        LLVMParser.charconst_return retval = new LLVMParser.charconst_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.charLiteral_return charLiteral89 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:205:34: ( charLiteral )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:206:2: charLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_charLiteral_in_charconst1049);
            charLiteral89=charLiteral();

            state._fsp--;

            adaptor.addChild(root_0, charLiteral89.getTree());
             
            		retval.value = (charLiteral89!=null?charLiteral89.theText:null).charAt(0);
            	

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "charconst"

    public static class stringconst_return extends ParserRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stringconst"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:211:1: stringconst returns [ String value ] : cstringLiteral ;
    public final LLVMParser.stringconst_return stringconst() throws RecognitionException {
        LLVMParser.stringconst_return retval = new LLVMParser.stringconst_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.cstringLiteral_return cstringLiteral90 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:211:39: ( cstringLiteral )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:212:2: cstringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_cstringLiteral_in_stringconst1066);
            cstringLiteral90=cstringLiteral();

            state._fsp--;

            adaptor.addChild(root_0, cstringLiteral90.getTree());

            		retval.value = (cstringLiteral90!=null?cstringLiteral90.theText:null);
            	

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stringconst"

    public static class structconst_return extends ParserRuleReturnScope {
        public LLOperand[] values;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structconst"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:217:1: structconst returns [ LLOperand[] values ] : '{' (t0= typedconstant ( ',' t1= typedconstant )* )? '}' ;
    public final LLVMParser.structconst_return structconst() throws RecognitionException {
        LLVMParser.structconst_return retval = new LLVMParser.structconst_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal91=null;
        Token char_literal92=null;
        Token char_literal93=null;
        LLVMParser.typedconstant_return t0 = null;

        LLVMParser.typedconstant_return t1 = null;


        CommonTree char_literal91_tree=null;
        CommonTree char_literal92_tree=null;
        CommonTree char_literal93_tree=null;


            List<LLOperand> ops = new ArrayList<LLOperand>();
          
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:224:3: ( '{' (t0= typedconstant ( ',' t1= typedconstant )* )? '}' )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:225:3: '{' (t0= typedconstant ( ',' t1= typedconstant )* )? '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal91=(Token)match(input,29,FOLLOW_29_in_structconst1103); 
            char_literal91_tree = (CommonTree)adaptor.create(char_literal91);
            adaptor.addChild(root_0, char_literal91_tree);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:225:7: (t0= typedconstant ( ',' t1= typedconstant )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=INT_TYPE && LA13_0<=QUOTED_ID)||LA13_0==27||LA13_0==29||LA13_0==31) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:225:8: t0= typedconstant ( ',' t1= typedconstant )*
                    {
                    pushFollow(FOLLOW_typedconstant_in_structconst1108);
                    t0=typedconstant();

                    state._fsp--;

                    adaptor.addChild(root_0, t0.getTree());
                     ops.add((t0!=null?t0.op:null)); 
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:226:5: ( ',' t1= typedconstant )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==36) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:226:6: ',' t1= typedconstant
                    	    {
                    	    char_literal92=(Token)match(input,36,FOLLOW_36_in_structconst1118); 
                    	    char_literal92_tree = (CommonTree)adaptor.create(char_literal92);
                    	    adaptor.addChild(root_0, char_literal92_tree);

                    	    pushFollow(FOLLOW_typedconstant_in_structconst1122);
                    	    t1=typedconstant();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, t1.getTree());
                    	     ops.add((t1!=null?t1.op:null)); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal93=(Token)match(input,30,FOLLOW_30_in_structconst1143); 
            char_literal93_tree = (CommonTree)adaptor.create(char_literal93);
            adaptor.addChild(root_0, char_literal93_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


                retval.values = ops.toArray(new LLOperand[ops.size()]);
              
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "structconst"

    public static class arrayconst_return extends ParserRuleReturnScope {
        public LLOperand[] values;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayconst"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:233:1: arrayconst returns [ LLOperand[] values ] : '[' (t0= typedconstant ( ',' t1= typedconstant )* )? ']' ;
    public final LLVMParser.arrayconst_return arrayconst() throws RecognitionException {
        LLVMParser.arrayconst_return retval = new LLVMParser.arrayconst_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal94=null;
        Token char_literal95=null;
        Token char_literal96=null;
        LLVMParser.typedconstant_return t0 = null;

        LLVMParser.typedconstant_return t1 = null;


        CommonTree char_literal94_tree=null;
        CommonTree char_literal95_tree=null;
        CommonTree char_literal96_tree=null;


            List<LLOperand> ops = new ArrayList<LLOperand>();
          
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:240:3: ( '[' (t0= typedconstant ( ',' t1= typedconstant )* )? ']' )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:241:3: '[' (t0= typedconstant ( ',' t1= typedconstant )* )? ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal94=(Token)match(input,31,FOLLOW_31_in_arrayconst1181); 
            char_literal94_tree = (CommonTree)adaptor.create(char_literal94);
            adaptor.addChild(root_0, char_literal94_tree);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:241:7: (t0= typedconstant ( ',' t1= typedconstant )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=INT_TYPE && LA15_0<=QUOTED_ID)||LA15_0==27||LA15_0==29||LA15_0==31) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:241:8: t0= typedconstant ( ',' t1= typedconstant )*
                    {
                    pushFollow(FOLLOW_typedconstant_in_arrayconst1186);
                    t0=typedconstant();

                    state._fsp--;

                    adaptor.addChild(root_0, t0.getTree());
                     ops.add((t0!=null?t0.op:null)); 
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:242:5: ( ',' t1= typedconstant )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==36) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:242:6: ',' t1= typedconstant
                    	    {
                    	    char_literal95=(Token)match(input,36,FOLLOW_36_in_arrayconst1196); 
                    	    char_literal95_tree = (CommonTree)adaptor.create(char_literal95);
                    	    adaptor.addChild(root_0, char_literal95_tree);

                    	    pushFollow(FOLLOW_typedconstant_in_arrayconst1200);
                    	    t1=typedconstant();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, t1.getTree());
                    	     ops.add((t1!=null?t1.op:null)); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal96=(Token)match(input,33,FOLLOW_33_in_arrayconst1221); 
            char_literal96_tree = (CommonTree)adaptor.create(char_literal96);
            adaptor.addChild(root_0, char_literal96_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


                retval.values = ops.toArray(new LLOperand[ops.size()]);
              
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayconst"

    public static class identifier_return extends ParserRuleReturnScope {
        public String theId;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "identifier"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:248:1: identifier returns [String theId] : ( NAMED_ID | UNNAMED_ID | QUOTED_ID ) ;
    public final LLVMParser.identifier_return identifier() throws RecognitionException {
        LLVMParser.identifier_return retval = new LLVMParser.identifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAMED_ID97=null;
        Token UNNAMED_ID98=null;
        Token QUOTED_ID99=null;

        CommonTree NAMED_ID97_tree=null;
        CommonTree UNNAMED_ID98_tree=null;
        CommonTree QUOTED_ID99_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:248:35: ( ( NAMED_ID | UNNAMED_ID | QUOTED_ID ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:249:3: ( NAMED_ID | UNNAMED_ID | QUOTED_ID )
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:249:3: ( NAMED_ID | UNNAMED_ID | QUOTED_ID )
            int alt16=3;
            switch ( input.LA(1) ) {
            case NAMED_ID:
                {
                alt16=1;
                }
                break;
            case UNNAMED_ID:
                {
                alt16=2;
                }
                break;
            case QUOTED_ID:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:250:2: NAMED_ID
                    {
                    NAMED_ID97=(Token)match(input,NAMED_ID,FOLLOW_NAMED_ID_in_identifier1245); 
                    NAMED_ID97_tree = (CommonTree)adaptor.create(NAMED_ID97);
                    adaptor.addChild(root_0, NAMED_ID97_tree);

                     retval.theId = (NAMED_ID97!=null?NAMED_ID97.getText():null); 

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:251:5: UNNAMED_ID
                    {
                    UNNAMED_ID98=(Token)match(input,UNNAMED_ID,FOLLOW_UNNAMED_ID_in_identifier1256); 
                    UNNAMED_ID98_tree = (CommonTree)adaptor.create(UNNAMED_ID98);
                    adaptor.addChild(root_0, UNNAMED_ID98_tree);

                     retval.theId = (UNNAMED_ID98!=null?UNNAMED_ID98.getText():null); 

                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:252:5: QUOTED_ID
                    {
                    QUOTED_ID99=(Token)match(input,QUOTED_ID,FOLLOW_QUOTED_ID_in_identifier1264); 
                    QUOTED_ID99_tree = (CommonTree)adaptor.create(QUOTED_ID99);
                    adaptor.addChild(root_0, QUOTED_ID99_tree);

                     retval.theId = (QUOTED_ID99!=null?QUOTED_ID99.getText():null).substring(0,1) 
                      						+ helper.unescape((QUOTED_ID99!=null?QUOTED_ID99.getText():null).substring(1), '"'); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identifier"

    public static class number_return extends ParserRuleReturnScope {
        public int value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "number"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:257:1: number returns [int value] : NUMBER ;
    public final LLVMParser.number_return number() throws RecognitionException {
        LLVMParser.number_return retval = new LLVMParser.number_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NUMBER100=null;

        CommonTree NUMBER100_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:257:28: ( NUMBER )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:257:30: NUMBER
            {
            root_0 = (CommonTree)adaptor.nil();

            NUMBER100=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_number1286); 
            NUMBER100_tree = (CommonTree)adaptor.create(NUMBER100);
            adaptor.addChild(root_0, NUMBER100_tree);

             retval.value = Integer.parseInt((NUMBER100!=null?NUMBER100.getText():null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "number"

    public static class charLiteral_return extends ParserRuleReturnScope {
        public String theText;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "charLiteral"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:260:1: charLiteral returns [String theText] : CHAR_LITERAL ;
    public final LLVMParser.charLiteral_return charLiteral() throws RecognitionException {
        LLVMParser.charLiteral_return retval = new LLVMParser.charLiteral_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CHAR_LITERAL101=null;

        CommonTree CHAR_LITERAL101_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:260:38: ( CHAR_LITERAL )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:260:40: CHAR_LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            CHAR_LITERAL101=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charLiteral1304); 
            CHAR_LITERAL101_tree = (CommonTree)adaptor.create(CHAR_LITERAL101);
            adaptor.addChild(root_0, CHAR_LITERAL101_tree);

             
              retval.theText = LLParserHelper.unescape((CHAR_LITERAL101!=null?CHAR_LITERAL101.getText():null), '\'');
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "charLiteral"

    public static class stringLiteral_return extends ParserRuleReturnScope {
        public String theText;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stringLiteral"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:266:1: stringLiteral returns [String theText] : STRING_LITERAL ;
    public final LLVMParser.stringLiteral_return stringLiteral() throws RecognitionException {
        LLVMParser.stringLiteral_return retval = new LLVMParser.stringLiteral_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING_LITERAL102=null;

        CommonTree STRING_LITERAL102_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:266:40: ( STRING_LITERAL )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:266:42: STRING_LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING_LITERAL102=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_stringLiteral1324); 
            STRING_LITERAL102_tree = (CommonTree)adaptor.create(STRING_LITERAL102);
            adaptor.addChild(root_0, STRING_LITERAL102_tree);


              retval.theText = LLParserHelper.unescape((STRING_LITERAL102!=null?STRING_LITERAL102.getText():null), '"');
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stringLiteral"

    public static class cstringLiteral_return extends ParserRuleReturnScope {
        public String theText;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cstringLiteral"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:272:1: cstringLiteral returns [String theText] : CSTRING_LITERAL ;
    public final LLVMParser.cstringLiteral_return cstringLiteral() throws RecognitionException {
        LLVMParser.cstringLiteral_return retval = new LLVMParser.cstringLiteral_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CSTRING_LITERAL103=null;

        CommonTree CSTRING_LITERAL103_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:272:41: ( CSTRING_LITERAL )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:272:43: CSTRING_LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            CSTRING_LITERAL103=(Token)match(input,CSTRING_LITERAL,FOLLOW_CSTRING_LITERAL_in_cstringLiteral1345); 
            CSTRING_LITERAL103_tree = (CommonTree)adaptor.create(CSTRING_LITERAL103);
            adaptor.addChild(root_0, CSTRING_LITERAL103_tree);


              retval.theText = LLParserHelper.unescape((CSTRING_LITERAL103!=null?CSTRING_LITERAL103.getText():null).substring(1), '"');
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cstringLiteral"

    public static class defineDirective_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defineDirective"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:278:1: defineDirective : DEFINE ( linkage )? ( visibility )? ( cconv )? attrs type identifier arglist fn_attrs NEWLINE '{' NEWLINE defineStmts '}' ;
    public final LLVMParser.defineDirective_return defineDirective() throws RecognitionException {
        LLVMParser.defineDirective_return retval = new LLVMParser.defineDirective_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DEFINE104=null;
        Token NEWLINE113=null;
        Token char_literal114=null;
        Token NEWLINE115=null;
        Token char_literal117=null;
        LLVMParser.linkage_return linkage105 = null;

        LLVMParser.visibility_return visibility106 = null;

        LLVMParser.cconv_return cconv107 = null;

        LLVMParser.attrs_return attrs108 = null;

        LLVMParser.type_return type109 = null;

        LLVMParser.identifier_return identifier110 = null;

        LLVMParser.arglist_return arglist111 = null;

        LLVMParser.fn_attrs_return fn_attrs112 = null;

        LLVMParser.defineStmts_return defineStmts116 = null;


        CommonTree DEFINE104_tree=null;
        CommonTree NEWLINE113_tree=null;
        CommonTree char_literal114_tree=null;
        CommonTree NEWLINE115_tree=null;
        CommonTree char_literal117_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:278:17: ( DEFINE ( linkage )? ( visibility )? ( cconv )? attrs type identifier arglist fn_attrs NEWLINE '{' NEWLINE defineStmts '}' )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:278:19: DEFINE ( linkage )? ( visibility )? ( cconv )? attrs type identifier arglist fn_attrs NEWLINE '{' NEWLINE defineStmts '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            DEFINE104=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_defineDirective1360); 
            DEFINE104_tree = (CommonTree)adaptor.create(DEFINE104);
            adaptor.addChild(root_0, DEFINE104_tree);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:278:26: ( linkage )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=40 && LA17_0<=53)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:278:26: linkage
                    {
                    pushFollow(FOLLOW_linkage_in_defineDirective1362);
                    linkage105=linkage();

                    state._fsp--;

                    adaptor.addChild(root_0, linkage105.getTree());

                    }
                    break;

            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:278:35: ( visibility )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=68 && LA18_0<=70)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:278:35: visibility
                    {
                    pushFollow(FOLLOW_visibility_in_defineDirective1365);
                    visibility106=visibility();

                    state._fsp--;

                    adaptor.addChild(root_0, visibility106.getTree());

                    }
                    break;

            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:278:47: ( cconv )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=71 && LA19_0<=75)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:278:47: cconv
                    {
                    pushFollow(FOLLOW_cconv_in_defineDirective1368);
                    cconv107=cconv();

                    state._fsp--;

                    adaptor.addChild(root_0, cconv107.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_attrs_in_defineDirective1371);
            attrs108=attrs();

            state._fsp--;

            adaptor.addChild(root_0, attrs108.getTree());
            pushFollow(FOLLOW_type_in_defineDirective1373);
            type109=type();

            state._fsp--;

            adaptor.addChild(root_0, type109.getTree());
            pushFollow(FOLLOW_identifier_in_defineDirective1375);
            identifier110=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier110.getTree());
            pushFollow(FOLLOW_arglist_in_defineDirective1377);
            arglist111=arglist();

            state._fsp--;

            adaptor.addChild(root_0, arglist111.getTree());
            pushFollow(FOLLOW_fn_attrs_in_defineDirective1379);
            fn_attrs112=fn_attrs();

            state._fsp--;

            adaptor.addChild(root_0, fn_attrs112.getTree());
            NEWLINE113=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_defineDirective1381); 
            NEWLINE113_tree = (CommonTree)adaptor.create(NEWLINE113);
            adaptor.addChild(root_0, NEWLINE113_tree);


                helper.openNewDefine(
                  (identifier110!=null?identifier110.theId:null),
                    (linkage105!=null?linkage105.value:null), (visibility106!=null?visibility106.vis:null), (cconv107!=null?input.toString(cconv107.start,cconv107.stop):null), 
                    new LLAttrType(new LLAttrs((attrs108!=null?attrs108.attrs:null)), (type109!=null?type109.theType:null)),
                    (arglist111!=null?arglist111.argAttrs:null), new LLFuncAttrs((fn_attrs112!=null?fn_attrs112.attrs:null)),
                    null, //section
                    0, //align
                    null //gc
                    );
                
            char_literal114=(Token)match(input,29,FOLLOW_29_in_defineDirective1400); 
            char_literal114_tree = (CommonTree)adaptor.create(char_literal114);
            adaptor.addChild(root_0, char_literal114_tree);

            NEWLINE115=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_defineDirective1402); 
            NEWLINE115_tree = (CommonTree)adaptor.create(NEWLINE115);
            adaptor.addChild(root_0, NEWLINE115_tree);

            pushFollow(FOLLOW_defineStmts_in_defineDirective1408);
            defineStmts116=defineStmts();

            state._fsp--;

            adaptor.addChild(root_0, defineStmts116.getTree());
            char_literal117=(Token)match(input,30,FOLLOW_30_in_defineDirective1415); 
            char_literal117_tree = (CommonTree)adaptor.create(char_literal117);
            adaptor.addChild(root_0, char_literal117_tree);


                helper.closeDefine();
                

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "defineDirective"

    public static class visibility_return extends ParserRuleReturnScope {
        public LLVisibility vis;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "visibility"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:301:1: visibility returns [LLVisibility vis] : ( 'default' | 'hidden' | 'protected' ) ;
    public final LLVMParser.visibility_return visibility() throws RecognitionException {
        LLVMParser.visibility_return retval = new LLVMParser.visibility_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set118=null;

        CommonTree set118_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:301:39: ( ( 'default' | 'hidden' | 'protected' ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:301:41: ( 'default' | 'hidden' | 'protected' )
            {
            root_0 = (CommonTree)adaptor.nil();

            set118=(Token)input.LT(1);
            if ( (input.LA(1)>=68 && input.LA(1)<=70) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set118));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             retval.vis = LLVisibility.getForToken(input.toString(retval.start,input.LT(-1))); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "visibility"

    public static class cconv_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cconv"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:304:1: cconv : ( 'ccc' | 'fastcc' | 'coldcc' | 'cc 10' | 'cc' number ) ;
    public final LLVMParser.cconv_return cconv() throws RecognitionException {
        LLVMParser.cconv_return retval = new LLVMParser.cconv_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal119=null;
        Token string_literal120=null;
        Token string_literal121=null;
        Token string_literal122=null;
        Token string_literal123=null;
        LLVMParser.number_return number124 = null;


        CommonTree string_literal119_tree=null;
        CommonTree string_literal120_tree=null;
        CommonTree string_literal121_tree=null;
        CommonTree string_literal122_tree=null;
        CommonTree string_literal123_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:304:7: ( ( 'ccc' | 'fastcc' | 'coldcc' | 'cc 10' | 'cc' number ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:304:9: ( 'ccc' | 'fastcc' | 'coldcc' | 'cc 10' | 'cc' number )
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:304:9: ( 'ccc' | 'fastcc' | 'coldcc' | 'cc 10' | 'cc' number )
            int alt20=5;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt20=1;
                }
                break;
            case 72:
                {
                alt20=2;
                }
                break;
            case 73:
                {
                alt20=3;
                }
                break;
            case 74:
                {
                alt20=4;
                }
                break;
            case 75:
                {
                alt20=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:304:10: 'ccc'
                    {
                    string_literal119=(Token)match(input,71,FOLLOW_71_in_cconv1474); 
                    string_literal119_tree = (CommonTree)adaptor.create(string_literal119);
                    adaptor.addChild(root_0, string_literal119_tree);


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:304:18: 'fastcc'
                    {
                    string_literal120=(Token)match(input,72,FOLLOW_72_in_cconv1478); 
                    string_literal120_tree = (CommonTree)adaptor.create(string_literal120);
                    adaptor.addChild(root_0, string_literal120_tree);


                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:304:29: 'coldcc'
                    {
                    string_literal121=(Token)match(input,73,FOLLOW_73_in_cconv1482); 
                    string_literal121_tree = (CommonTree)adaptor.create(string_literal121);
                    adaptor.addChild(root_0, string_literal121_tree);


                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:304:40: 'cc 10'
                    {
                    string_literal122=(Token)match(input,74,FOLLOW_74_in_cconv1486); 
                    string_literal122_tree = (CommonTree)adaptor.create(string_literal122);
                    adaptor.addChild(root_0, string_literal122_tree);


                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:304:50: 'cc' number
                    {
                    string_literal123=(Token)match(input,75,FOLLOW_75_in_cconv1490); 
                    string_literal123_tree = (CommonTree)adaptor.create(string_literal123);
                    adaptor.addChild(root_0, string_literal123_tree);

                    pushFollow(FOLLOW_number_in_cconv1492);
                    number124=number();

                    state._fsp--;

                    adaptor.addChild(root_0, number124.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cconv"

    public static class attrs_return extends ParserRuleReturnScope {
        public String[] attrs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrs"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:307:1: attrs returns [String[] attrs] : ( attr )* ;
    public final LLVMParser.attrs_return attrs() throws RecognitionException {
        LLVMParser.attrs_return retval = new LLVMParser.attrs_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.attr_return attr125 = null;




            List<String> attrs = new ArrayList<String>();
          
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:315:3: ( ( attr )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:315:5: ( attr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:315:5: ( attr )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=76 && LA21_0<=83)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:315:7: attr
            	    {
            	    pushFollow(FOLLOW_attr_in_attrs1531);
            	    attr125=attr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attr125.getTree());
            	     attrs.add((attr125!=null?input.toString(attr125.start,attr125.stop):null)); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


                retval.attrs = attrs.toArray(new String[attrs.size()]);
              
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrs"

    public static class attr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:318:1: attr : ( 'zeroext' | 'signext' | 'inreg' | 'byval' | 'sret' | 'noalias' | 'nocapture' | 'nest' );
    public final LLVMParser.attr_return attr() throws RecognitionException {
        LLVMParser.attr_return retval = new LLVMParser.attr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set126=null;

        CommonTree set126_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:318:6: ( 'zeroext' | 'signext' | 'inreg' | 'byval' | 'sret' | 'noalias' | 'nocapture' | 'nest' )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set126=(Token)input.LT(1);
            if ( (input.LA(1)>=76 && input.LA(1)<=83) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set126));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attr"

    public static class fn_attrs_return extends ParserRuleReturnScope {
        public String[] attrs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fn_attrs"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:321:1: fn_attrs returns [String[] attrs] : ( fn_attr )* ;
    public final LLVMParser.fn_attrs_return fn_attrs() throws RecognitionException {
        LLVMParser.fn_attrs_return retval = new LLVMParser.fn_attrs_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.fn_attr_return fn_attr127 = null;




            List<String> attrs = new ArrayList<String>();
          
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:329:3: ( ( fn_attr )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:329:5: ( fn_attr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:329:5: ( fn_attr )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=84 && LA22_0<=97)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:329:7: fn_attr
            	    {
            	    pushFollow(FOLLOW_fn_attr_in_fn_attrs1610);
            	    fn_attr127=fn_attr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, fn_attr127.getTree());
            	     attrs.add((fn_attr127!=null?input.toString(fn_attr127.start,fn_attr127.stop):null)); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


                retval.attrs = attrs.toArray(new String[attrs.size()]);
              
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fn_attrs"

    public static class fn_attr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fn_attr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:332:1: fn_attr : ( ( 'alignstack' '(' number ')' ) | 'alwaysinline' | 'inlinehint' | 'noinline' | 'optsize' | 'noreturn' | 'nounwind' | 'readnone' | 'readonly' | 'ssp' | 'sspreq' | 'noredzone' | 'noimplicitfloat' | 'naked' );
    public final LLVMParser.fn_attr_return fn_attr() throws RecognitionException {
        LLVMParser.fn_attr_return retval = new LLVMParser.fn_attr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal128=null;
        Token char_literal129=null;
        Token char_literal131=null;
        Token string_literal132=null;
        Token string_literal133=null;
        Token string_literal134=null;
        Token string_literal135=null;
        Token string_literal136=null;
        Token string_literal137=null;
        Token string_literal138=null;
        Token string_literal139=null;
        Token string_literal140=null;
        Token string_literal141=null;
        Token string_literal142=null;
        Token string_literal143=null;
        Token string_literal144=null;
        LLVMParser.number_return number130 = null;


        CommonTree string_literal128_tree=null;
        CommonTree char_literal129_tree=null;
        CommonTree char_literal131_tree=null;
        CommonTree string_literal132_tree=null;
        CommonTree string_literal133_tree=null;
        CommonTree string_literal134_tree=null;
        CommonTree string_literal135_tree=null;
        CommonTree string_literal136_tree=null;
        CommonTree string_literal137_tree=null;
        CommonTree string_literal138_tree=null;
        CommonTree string_literal139_tree=null;
        CommonTree string_literal140_tree=null;
        CommonTree string_literal141_tree=null;
        CommonTree string_literal142_tree=null;
        CommonTree string_literal143_tree=null;
        CommonTree string_literal144_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:332:9: ( ( 'alignstack' '(' number ')' ) | 'alwaysinline' | 'inlinehint' | 'noinline' | 'optsize' | 'noreturn' | 'nounwind' | 'readnone' | 'readonly' | 'ssp' | 'sspreq' | 'noredzone' | 'noimplicitfloat' | 'naked' )
            int alt23=14;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt23=1;
                }
                break;
            case 85:
                {
                alt23=2;
                }
                break;
            case 86:
                {
                alt23=3;
                }
                break;
            case 87:
                {
                alt23=4;
                }
                break;
            case 88:
                {
                alt23=5;
                }
                break;
            case 89:
                {
                alt23=6;
                }
                break;
            case 90:
                {
                alt23=7;
                }
                break;
            case 91:
                {
                alt23=8;
                }
                break;
            case 92:
                {
                alt23=9;
                }
                break;
            case 93:
                {
                alt23=10;
                }
                break;
            case 94:
                {
                alt23=11;
                }
                break;
            case 95:
                {
                alt23=12;
                }
                break;
            case 96:
                {
                alt23=13;
                }
                break;
            case 97:
                {
                alt23=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:332:11: ( 'alignstack' '(' number ')' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:332:11: ( 'alignstack' '(' number ')' )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:332:13: 'alignstack' '(' number ')'
                    {
                    string_literal128=(Token)match(input,84,FOLLOW_84_in_fn_attr1629); 
                    string_literal128_tree = (CommonTree)adaptor.create(string_literal128);
                    adaptor.addChild(root_0, string_literal128_tree);

                    char_literal129=(Token)match(input,34,FOLLOW_34_in_fn_attr1631); 
                    char_literal129_tree = (CommonTree)adaptor.create(char_literal129);
                    adaptor.addChild(root_0, char_literal129_tree);

                    pushFollow(FOLLOW_number_in_fn_attr1633);
                    number130=number();

                    state._fsp--;

                    adaptor.addChild(root_0, number130.getTree());
                    char_literal131=(Token)match(input,35,FOLLOW_35_in_fn_attr1635); 
                    char_literal131_tree = (CommonTree)adaptor.create(char_literal131);
                    adaptor.addChild(root_0, char_literal131_tree);


                    }


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:332:45: 'alwaysinline'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal132=(Token)match(input,85,FOLLOW_85_in_fn_attr1641); 
                    string_literal132_tree = (CommonTree)adaptor.create(string_literal132);
                    adaptor.addChild(root_0, string_literal132_tree);


                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:332:62: 'inlinehint'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal133=(Token)match(input,86,FOLLOW_86_in_fn_attr1645); 
                    string_literal133_tree = (CommonTree)adaptor.create(string_literal133);
                    adaptor.addChild(root_0, string_literal133_tree);


                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:332:77: 'noinline'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal134=(Token)match(input,87,FOLLOW_87_in_fn_attr1649); 
                    string_literal134_tree = (CommonTree)adaptor.create(string_literal134);
                    adaptor.addChild(root_0, string_literal134_tree);


                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:332:90: 'optsize'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal135=(Token)match(input,88,FOLLOW_88_in_fn_attr1653); 
                    string_literal135_tree = (CommonTree)adaptor.create(string_literal135);
                    adaptor.addChild(root_0, string_literal135_tree);


                    }
                    break;
                case 6 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:333:7: 'noreturn'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal136=(Token)match(input,89,FOLLOW_89_in_fn_attr1662); 
                    string_literal136_tree = (CommonTree)adaptor.create(string_literal136);
                    adaptor.addChild(root_0, string_literal136_tree);


                    }
                    break;
                case 7 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:333:20: 'nounwind'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal137=(Token)match(input,90,FOLLOW_90_in_fn_attr1666); 
                    string_literal137_tree = (CommonTree)adaptor.create(string_literal137);
                    adaptor.addChild(root_0, string_literal137_tree);


                    }
                    break;
                case 8 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:333:33: 'readnone'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal138=(Token)match(input,91,FOLLOW_91_in_fn_attr1670); 
                    string_literal138_tree = (CommonTree)adaptor.create(string_literal138);
                    adaptor.addChild(root_0, string_literal138_tree);


                    }
                    break;
                case 9 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:333:46: 'readonly'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal139=(Token)match(input,92,FOLLOW_92_in_fn_attr1674); 
                    string_literal139_tree = (CommonTree)adaptor.create(string_literal139);
                    adaptor.addChild(root_0, string_literal139_tree);


                    }
                    break;
                case 10 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:333:59: 'ssp'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal140=(Token)match(input,93,FOLLOW_93_in_fn_attr1678); 
                    string_literal140_tree = (CommonTree)adaptor.create(string_literal140);
                    adaptor.addChild(root_0, string_literal140_tree);


                    }
                    break;
                case 11 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:333:67: 'sspreq'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal141=(Token)match(input,94,FOLLOW_94_in_fn_attr1682); 
                    string_literal141_tree = (CommonTree)adaptor.create(string_literal141);
                    adaptor.addChild(root_0, string_literal141_tree);


                    }
                    break;
                case 12 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:333:78: 'noredzone'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal142=(Token)match(input,95,FOLLOW_95_in_fn_attr1686); 
                    string_literal142_tree = (CommonTree)adaptor.create(string_literal142);
                    adaptor.addChild(root_0, string_literal142_tree);


                    }
                    break;
                case 13 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:333:92: 'noimplicitfloat'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal143=(Token)match(input,96,FOLLOW_96_in_fn_attr1690); 
                    string_literal143_tree = (CommonTree)adaptor.create(string_literal143);
                    adaptor.addChild(root_0, string_literal143_tree);


                    }
                    break;
                case 14 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:333:112: 'naked'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal144=(Token)match(input,97,FOLLOW_97_in_fn_attr1694); 
                    string_literal144_tree = (CommonTree)adaptor.create(string_literal144);
                    adaptor.addChild(root_0, string_literal144_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fn_attr"

    public static class arglist_return extends ParserRuleReturnScope {
        public LLArgAttrType[] argAttrs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arglist"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:339:1: arglist returns [ LLArgAttrType[] argAttrs ] : '(' (f0= funcarg ( ',' f1= funcarg )* )? ')' ;
    public final LLVMParser.arglist_return arglist() throws RecognitionException {
        LLVMParser.arglist_return retval = new LLVMParser.arglist_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal145=null;
        Token char_literal146=null;
        Token char_literal147=null;
        LLVMParser.funcarg_return f0 = null;

        LLVMParser.funcarg_return f1 = null;


        CommonTree char_literal145_tree=null;
        CommonTree char_literal146_tree=null;
        CommonTree char_literal147_tree=null;


            List<LLArgAttrType> attrs = new ArrayList<LLArgAttrType>();
          
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:347:3: ( '(' (f0= funcarg ( ',' f1= funcarg )* )? ')' )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:347:5: '(' (f0= funcarg ( ',' f1= funcarg )* )? ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal145=(Token)match(input,34,FOLLOW_34_in_arglist1733); 
            char_literal145_tree = (CommonTree)adaptor.create(char_literal145);
            adaptor.addChild(root_0, char_literal145_tree);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:348:7: (f0= funcarg ( ',' f1= funcarg )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=INT_TYPE && LA25_0<=QUOTED_ID)||LA25_0==27||LA25_0==29||LA25_0==31) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:348:9: f0= funcarg ( ',' f1= funcarg )*
                    {
                    pushFollow(FOLLOW_funcarg_in_arglist1746);
                    f0=funcarg();

                    state._fsp--;

                    adaptor.addChild(root_0, f0.getTree());
                     attrs.add((f0!=null?f0.argAttr:null)); 
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:349:9: ( ',' f1= funcarg )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==36) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:349:11: ',' f1= funcarg
                    	    {
                    	    char_literal146=(Token)match(input,36,FOLLOW_36_in_arglist1768); 
                    	    char_literal146_tree = (CommonTree)adaptor.create(char_literal146);
                    	    adaptor.addChild(root_0, char_literal146_tree);

                    	    pushFollow(FOLLOW_funcarg_in_arglist1772);
                    	    f1=funcarg();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, f1.getTree());
                    	     attrs.add((f1!=null?f1.argAttr:null)); 

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal147=(Token)match(input,35,FOLLOW_35_in_arglist1806); 
            char_literal147_tree = (CommonTree)adaptor.create(char_literal147);
            adaptor.addChild(root_0, char_literal147_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


                retval.argAttrs = attrs.toArray(new LLArgAttrType[attrs.size()]);
              
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arglist"

    public static class funcarg_return extends ParserRuleReturnScope {
        public LLArgAttrType argAttr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "funcarg"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:355:1: funcarg returns [ LLArgAttrType argAttr ] : type attrs identifier ;
    public final LLVMParser.funcarg_return funcarg() throws RecognitionException {
        LLVMParser.funcarg_return retval = new LLVMParser.funcarg_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.type_return type148 = null;

        LLVMParser.attrs_return attrs149 = null;

        LLVMParser.identifier_return identifier150 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:355:43: ( type attrs identifier )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:356:3: type attrs identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_funcarg1824);
            type148=type();

            state._fsp--;

            adaptor.addChild(root_0, type148.getTree());
            pushFollow(FOLLOW_attrs_in_funcarg1826);
            attrs149=attrs();

            state._fsp--;

            adaptor.addChild(root_0, attrs149.getTree());
            pushFollow(FOLLOW_identifier_in_funcarg1828);
            identifier150=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier150.getTree());
             retval.argAttr = new LLArgAttrType((identifier150!=null?identifier150.theId:null).substring(1), new LLAttrs((attrs149!=null?attrs149.attrs:null)), (type148!=null?type148.theType:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "funcarg"

    public static class defineStmts_return extends ParserRuleReturnScope {
        public List<LLBlock> blocks;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defineStmts"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:359:1: defineStmts returns [ List<LLBlock> blocks ] : ( block )+ ;
    public final LLVMParser.defineStmts_return defineStmts() throws RecognitionException {
        LLVMParser.defineStmts_return retval = new LLVMParser.defineStmts_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.block_return block151 = null;




            List<LLBlock> blocks = new ArrayList<LLBlock>();
          
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:367:3: ( ( block )+ )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:367:5: ( block )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:367:5: ( block )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==LABEL) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:367:7: block
            	    {
            	    pushFollow(FOLLOW_block_in_defineStmts1868);
            	    block151=block();

            	    state._fsp--;

            	    adaptor.addChild(root_0, block151.getTree());
            	     blocks.add((block151!=null?block151.block:null)); 

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


                retval.blocks = blocks;
              
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "defineStmts"

    public static class block_return extends ParserRuleReturnScope {
        public LLBlock block;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:370:1: block returns [ LLBlock block ] : blocklabel ( instr NEWLINE )+ ;
    public final LLVMParser.block_return block() throws RecognitionException {
        LLVMParser.block_return retval = new LLVMParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE154=null;
        LLVMParser.blocklabel_return blocklabel152 = null;

        LLVMParser.instr_return instr153 = null;


        CommonTree NEWLINE154_tree=null;


            LLBlock block;
          
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:377:3: ( blocklabel ( instr NEWLINE )+ )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:378:3: blocklabel ( instr NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_blocklabel_in_block1912);
            blocklabel152=blocklabel();

            state._fsp--;

            adaptor.addChild(root_0, blocklabel152.getTree());
             block = helper.currentTarget.addBlock((blocklabel152!=null?blocklabel152.theSym:null)); 
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:380:3: ( instr NEWLINE )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==NAMED_ID||(LA27_0>=100 && LA27_0<=102)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:380:5: instr NEWLINE
            	    {
            	    pushFollow(FOLLOW_instr_in_block1926);
            	    instr153=instr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instr153.getTree());
            	    NEWLINE154=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block1928); 
            	    NEWLINE154_tree = (CommonTree)adaptor.create(NEWLINE154);
            	    adaptor.addChild(root_0, NEWLINE154_tree);

            	     block.instrs().add((instr153!=null?instr153.inst:null)); 

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


                retval.block = block;
              
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class blocklabel_return extends ParserRuleReturnScope {
        public ISymbol theSym;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "blocklabel"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:384:1: blocklabel returns [ ISymbol theSym ] : LABEL ':' NEWLINE ;
    public final LLVMParser.blocklabel_return blocklabel() throws RecognitionException {
        LLVMParser.blocklabel_return retval = new LLVMParser.blocklabel_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LABEL155=null;
        Token char_literal156=null;
        Token NEWLINE157=null;

        CommonTree LABEL155_tree=null;
        CommonTree char_literal156_tree=null;
        CommonTree NEWLINE157_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:384:39: ( LABEL ':' NEWLINE )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:384:41: LABEL ':' NEWLINE
            {
            root_0 = (CommonTree)adaptor.nil();

            LABEL155=(Token)match(input,LABEL,FOLLOW_LABEL_in_blocklabel1954); 
            LABEL155_tree = (CommonTree)adaptor.create(LABEL155);
            adaptor.addChild(root_0, LABEL155_tree);

            char_literal156=(Token)match(input,98,FOLLOW_98_in_blocklabel1956); 
            char_literal156_tree = (CommonTree)adaptor.create(char_literal156);
            adaptor.addChild(root_0, char_literal156_tree);

            NEWLINE157=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_blocklabel1958); 
            NEWLINE157_tree = (CommonTree)adaptor.create(NEWLINE157);
            adaptor.addChild(root_0, NEWLINE157_tree);

             
                retval.theSym = helper.addLabel((LABEL155!=null?LABEL155.getText():null));
                

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "blocklabel"

    public static class instr_return extends ParserRuleReturnScope {
        public LLInstr inst;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:390:1: instr returns [LLInstr inst ] : ( ( allocaInstr ) | ( storeInstr ) | ( branchInstr ) | ( uncondBranchInstr ) | ( retInstr ) );
    public final LLVMParser.instr_return instr() throws RecognitionException {
        LLVMParser.instr_return retval = new LLVMParser.instr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.allocaInstr_return allocaInstr158 = null;

        LLVMParser.storeInstr_return storeInstr159 = null;

        LLVMParser.branchInstr_return branchInstr160 = null;

        LLVMParser.uncondBranchInstr_return uncondBranchInstr161 = null;

        LLVMParser.retInstr_return retInstr162 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:390:31: ( ( allocaInstr ) | ( storeInstr ) | ( branchInstr ) | ( uncondBranchInstr ) | ( retInstr ) )
            int alt28=5;
            switch ( input.LA(1) ) {
            case NAMED_ID:
                {
                alt28=1;
                }
                break;
            case 100:
                {
                alt28=2;
                }
                break;
            case 102:
                {
                int LA28_3 = input.LA(2);

                if ( (LA28_3==103) ) {
                    alt28=4;
                }
                else if ( ((LA28_3>=INT_TYPE && LA28_3<=QUOTED_ID)||LA28_3==27||LA28_3==29||LA28_3==31) ) {
                    alt28=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 3, input);

                    throw nvae;
                }
                }
                break;
            case 101:
                {
                alt28=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:391:3: ( allocaInstr )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:391:3: ( allocaInstr )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:391:5: allocaInstr
                    {
                    pushFollow(FOLLOW_allocaInstr_in_instr1987);
                    allocaInstr158=allocaInstr();

                    state._fsp--;

                    adaptor.addChild(root_0, allocaInstr158.getTree());
                     retval.inst = (allocaInstr158!=null?allocaInstr158.inst:null); 

                    }


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:392:5: ( storeInstr )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:392:5: ( storeInstr )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:392:7: storeInstr
                    {
                    pushFollow(FOLLOW_storeInstr_in_instr2010);
                    storeInstr159=storeInstr();

                    state._fsp--;

                    adaptor.addChild(root_0, storeInstr159.getTree());
                     retval.inst = (storeInstr159!=null?storeInstr159.inst:null); 

                    }


                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:393:5: ( branchInstr )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:393:5: ( branchInstr )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:393:7: branchInstr
                    {
                    pushFollow(FOLLOW_branchInstr_in_instr2031);
                    branchInstr160=branchInstr();

                    state._fsp--;

                    adaptor.addChild(root_0, branchInstr160.getTree());
                     retval.inst = (branchInstr160!=null?branchInstr160.inst:null); 

                    }


                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:394:5: ( uncondBranchInstr )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:394:5: ( uncondBranchInstr )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:394:7: uncondBranchInstr
                    {
                    pushFollow(FOLLOW_uncondBranchInstr_in_instr2051);
                    uncondBranchInstr161=uncondBranchInstr();

                    state._fsp--;

                    adaptor.addChild(root_0, uncondBranchInstr161.getTree());
                     retval.inst = (uncondBranchInstr161!=null?uncondBranchInstr161.inst:null); 

                    }


                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:395:5: ( retInstr )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:395:5: ( retInstr )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:395:7: retInstr
                    {
                    pushFollow(FOLLOW_retInstr_in_instr2065);
                    retInstr162=retInstr();

                    state._fsp--;

                    adaptor.addChild(root_0, retInstr162.getTree());
                     retval.inst = (retInstr162!=null?retInstr162.inst:null); 

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "instr"

    public static class ret_return extends ParserRuleReturnScope {
        public LLOperand op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ret"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:399:1: ret returns [LLOperand op] : UNNAMED_ID ;
    public final LLVMParser.ret_return ret() throws RecognitionException {
        LLVMParser.ret_return retval = new LLVMParser.ret_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token UNNAMED_ID163=null;

        CommonTree UNNAMED_ID163_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:399:28: ( UNNAMED_ID )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:400:5: UNNAMED_ID
            {
            root_0 = (CommonTree)adaptor.nil();

            UNNAMED_ID163=(Token)match(input,UNNAMED_ID,FOLLOW_UNNAMED_ID_in_ret2101); 
            UNNAMED_ID163_tree = (CommonTree)adaptor.create(UNNAMED_ID163);
            adaptor.addChild(root_0, UNNAMED_ID163_tree);

             retval.op = new LLTempOp(Integer.parseInt((UNNAMED_ID163!=null?UNNAMED_ID163.getText():null).substring(1)), null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ret"

    public static class local_return extends ParserRuleReturnScope {
        public LLOperand op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "local"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:403:1: local returns [LLOperand op] : NAMED_ID ;
    public final LLVMParser.local_return local() throws RecognitionException {
        LLVMParser.local_return retval = new LLVMParser.local_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAMED_ID164=null;

        CommonTree NAMED_ID164_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:403:30: ( NAMED_ID )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:404:5: NAMED_ID
            {
            root_0 = (CommonTree)adaptor.nil();

            NAMED_ID164=(Token)match(input,NAMED_ID,FOLLOW_NAMED_ID_in_local2128); 
            NAMED_ID164_tree = (CommonTree)adaptor.create(NAMED_ID164);
            adaptor.addChild(root_0, NAMED_ID164_tree);

             retval.op = new LLSymbolOp(helper.defineSymbol((NAMED_ID164!=null?NAMED_ID164.getText():null))); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "local"

    public static class allocaInstr_return extends ParserRuleReturnScope {
        public LLAllocaInstr inst;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "allocaInstr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:407:1: allocaInstr returns [LLAllocaInstr inst] : local EQUALS 'alloca' type ( typedconstant )? ;
    public final LLVMParser.allocaInstr_return allocaInstr() throws RecognitionException {
        LLVMParser.allocaInstr_return retval = new LLVMParser.allocaInstr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS166=null;
        Token string_literal167=null;
        LLVMParser.local_return local165 = null;

        LLVMParser.type_return type168 = null;

        LLVMParser.typedconstant_return typedconstant169 = null;


        CommonTree EQUALS166_tree=null;
        CommonTree string_literal167_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:407:42: ( local EQUALS 'alloca' type ( typedconstant )? )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:408:3: local EQUALS 'alloca' type ( typedconstant )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_local_in_allocaInstr2152);
            local165=local();

            state._fsp--;

            adaptor.addChild(root_0, local165.getTree());
            EQUALS166=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_allocaInstr2154); 
            EQUALS166_tree = (CommonTree)adaptor.create(EQUALS166);
            adaptor.addChild(root_0, EQUALS166_tree);

            string_literal167=(Token)match(input,99,FOLLOW_99_in_allocaInstr2156); 
            string_literal167_tree = (CommonTree)adaptor.create(string_literal167);
            adaptor.addChild(root_0, string_literal167_tree);

            pushFollow(FOLLOW_type_in_allocaInstr2158);
            type168=type();

            state._fsp--;

            adaptor.addChild(root_0, type168.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:408:30: ( typedconstant )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=INT_TYPE && LA29_0<=QUOTED_ID)||LA29_0==27||LA29_0==29||LA29_0==31) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:408:30: typedconstant
                    {
                    pushFollow(FOLLOW_typedconstant_in_allocaInstr2160);
                    typedconstant169=typedconstant();

                    state._fsp--;

                    adaptor.addChild(root_0, typedconstant169.getTree());

                    }
                    break;

            }

             retval.inst = (typedconstant169!=null?typedconstant169.op:null) == null 
                ? new LLAllocaInstr((local165!=null?local165.op:null), (type168!=null?type168.theType:null)) 
                : new LLAllocaInstr((local165!=null?local165.op:null), (type168!=null?type168.theType:null), (typedconstant169!=null?typedconstant169.op:null)); 
              
              (local165!=null?local165.op:null).setType((type168!=null?type168.theType:null));
              retval.inst.setType((type168!=null?type168.theType:null));
              ((LLSymbolOp)retval.inst.getResult()).getSymbol().setType((type168!=null?type168.theType:null));
              retval.inst.getResult().setType((type168!=null?type168.theType:null));  
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "allocaInstr"

    public static class typedop_return extends ParserRuleReturnScope {
        public LLOperand op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typedop"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:419:1: typedop returns [LLOperand op] : ( typedconstant ) ;
    public final LLVMParser.typedop_return typedop() throws RecognitionException {
        LLVMParser.typedop_return retval = new LLVMParser.typedop_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        LLVMParser.typedconstant_return typedconstant170 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:419:32: ( ( typedconstant ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:420:3: ( typedconstant )
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:420:3: ( typedconstant )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:420:5: typedconstant
            {
            pushFollow(FOLLOW_typedconstant_in_typedop2184);
            typedconstant170=typedconstant();

            state._fsp--;

            adaptor.addChild(root_0, typedconstant170.getTree());
             retval.op = (typedconstant170!=null?typedconstant170.op:null); 

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typedop"

    public static class storeInstr_return extends ParserRuleReturnScope {
        public LLStoreInstr inst;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "storeInstr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:422:1: storeInstr returns [LLStoreInstr inst] : 'store' o1= typedop ',' o2= typedop ;
    public final LLVMParser.storeInstr_return storeInstr() throws RecognitionException {
        LLVMParser.storeInstr_return retval = new LLVMParser.storeInstr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal171=null;
        Token char_literal172=null;
        LLVMParser.typedop_return o1 = null;

        LLVMParser.typedop_return o2 = null;


        CommonTree string_literal171_tree=null;
        CommonTree char_literal172_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:422:40: ( 'store' o1= typedop ',' o2= typedop )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:423:3: 'store' o1= typedop ',' o2= typedop
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal171=(Token)match(input,100,FOLLOW_100_in_storeInstr2208); 
            string_literal171_tree = (CommonTree)adaptor.create(string_literal171);
            adaptor.addChild(root_0, string_literal171_tree);

            pushFollow(FOLLOW_typedop_in_storeInstr2212);
            o1=typedop();

            state._fsp--;

            adaptor.addChild(root_0, o1.getTree());
            char_literal172=(Token)match(input,36,FOLLOW_36_in_storeInstr2214); 
            char_literal172_tree = (CommonTree)adaptor.create(char_literal172);
            adaptor.addChild(root_0, char_literal172_tree);

            pushFollow(FOLLOW_typedop_in_storeInstr2218);
            o2=typedop();

            state._fsp--;

            adaptor.addChild(root_0, o2.getTree());
             retval.inst = new LLStoreInstr((o2!=null?o2.op:null).getType(), (o1!=null?o1.op:null), (o2!=null?o2.op:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "storeInstr"

    public static class retInstr_return extends ParserRuleReturnScope {
        public LLRetInstr inst;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "retInstr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:427:1: retInstr returns [LLRetInstr inst] : 'ret' ( ( 'void' ) | (o1= typedop ) ) ;
    public final LLVMParser.retInstr_return retInstr() throws RecognitionException {
        LLVMParser.retInstr_return retval = new LLVMParser.retInstr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal173=null;
        Token string_literal174=null;
        LLVMParser.typedop_return o1 = null;


        CommonTree string_literal173_tree=null;
        CommonTree string_literal174_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:427:36: ( 'ret' ( ( 'void' ) | (o1= typedop ) ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:428:3: 'ret' ( ( 'void' ) | (o1= typedop ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal173=(Token)match(input,101,FOLLOW_101_in_retInstr2244); 
            string_literal173_tree = (CommonTree)adaptor.create(string_literal173);
            adaptor.addChild(root_0, string_literal173_tree);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:428:9: ( ( 'void' ) | (o1= typedop ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==27) ) {
                int LA30_1 = input.LA(2);

                if ( ((LA30_1>=NAMED_ID && LA30_1<=CHAR_LITERAL)||LA30_1==CSTRING_LITERAL||(LA30_1>=28 && LA30_1<=29)||LA30_1==31||LA30_1==34||LA30_1==54||(LA30_1>=56 && LA30_1<=67)) ) {
                    alt30=2;
                }
                else if ( (LA30_1==NEWLINE) ) {
                    alt30=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA30_0>=INT_TYPE && LA30_0<=QUOTED_ID)||LA30_0==29||LA30_0==31) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:428:11: ( 'void' )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:428:11: ( 'void' )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:428:13: 'void'
                    {
                    string_literal174=(Token)match(input,27,FOLLOW_27_in_retInstr2250); 
                    string_literal174_tree = (CommonTree)adaptor.create(string_literal174);
                    adaptor.addChild(root_0, string_literal174_tree);

                     retval.inst = new LLRetInstr(helper.typeEngine.VOID); 

                    }


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:429:13: (o1= typedop )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:429:13: (o1= typedop )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:429:15: o1= typedop
                    {
                    pushFollow(FOLLOW_typedop_in_retInstr2281);
                    o1=typedop();

                    state._fsp--;

                    adaptor.addChild(root_0, o1.getTree());
                     retval.inst = new LLRetInstr((o1!=null?o1.op:null).getType(), (o1!=null?o1.op:null)); 

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "retInstr"

    public static class branchInstr_return extends ParserRuleReturnScope {
        public LLInstr inst;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "branchInstr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:433:1: branchInstr returns [LLInstr inst] : 'br' typedop ',' 'label' t= identifier ',' 'label' f= identifier ;
    public final LLVMParser.branchInstr_return branchInstr() throws RecognitionException {
        LLVMParser.branchInstr_return retval = new LLVMParser.branchInstr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal175=null;
        Token char_literal177=null;
        Token string_literal178=null;
        Token char_literal179=null;
        Token string_literal180=null;
        LLVMParser.identifier_return t = null;

        LLVMParser.identifier_return f = null;

        LLVMParser.typedop_return typedop176 = null;


        CommonTree string_literal175_tree=null;
        CommonTree char_literal177_tree=null;
        CommonTree string_literal178_tree=null;
        CommonTree char_literal179_tree=null;
        CommonTree string_literal180_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:433:36: ( 'br' typedop ',' 'label' t= identifier ',' 'label' f= identifier )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:434:3: 'br' typedop ',' 'label' t= identifier ',' 'label' f= identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal175=(Token)match(input,102,FOLLOW_102_in_branchInstr2315); 
            string_literal175_tree = (CommonTree)adaptor.create(string_literal175);
            adaptor.addChild(root_0, string_literal175_tree);

            pushFollow(FOLLOW_typedop_in_branchInstr2317);
            typedop176=typedop();

            state._fsp--;

            adaptor.addChild(root_0, typedop176.getTree());
            char_literal177=(Token)match(input,36,FOLLOW_36_in_branchInstr2319); 
            char_literal177_tree = (CommonTree)adaptor.create(char_literal177);
            adaptor.addChild(root_0, char_literal177_tree);

            string_literal178=(Token)match(input,103,FOLLOW_103_in_branchInstr2321); 
            string_literal178_tree = (CommonTree)adaptor.create(string_literal178);
            adaptor.addChild(root_0, string_literal178_tree);

            pushFollow(FOLLOW_identifier_in_branchInstr2325);
            t=identifier();

            state._fsp--;

            adaptor.addChild(root_0, t.getTree());
            char_literal179=(Token)match(input,36,FOLLOW_36_in_branchInstr2327); 
            char_literal179_tree = (CommonTree)adaptor.create(char_literal179);
            adaptor.addChild(root_0, char_literal179_tree);

            string_literal180=(Token)match(input,103,FOLLOW_103_in_branchInstr2329); 
            string_literal180_tree = (CommonTree)adaptor.create(string_literal180);
            adaptor.addChild(root_0, string_literal180_tree);

            pushFollow(FOLLOW_identifier_in_branchInstr2333);
            f=identifier();

            state._fsp--;

            adaptor.addChild(root_0, f.getTree());
             retval.inst = new LLBranchInstr((typedop176!=null?typedop176.op:null).getType(), (typedop176!=null?typedop176.op:null), helper.getSymbolOp((t!=null?t.theId:null), null), helper.getSymbolOp((f!=null?f.theId:null), null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "branchInstr"

    public static class uncondBranchInstr_return extends ParserRuleReturnScope {
        public LLInstr inst;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "uncondBranchInstr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:438:1: uncondBranchInstr returns [LLInstr inst] : 'br' 'label' identifier ;
    public final LLVMParser.uncondBranchInstr_return uncondBranchInstr() throws RecognitionException {
        LLVMParser.uncondBranchInstr_return retval = new LLVMParser.uncondBranchInstr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal181=null;
        Token string_literal182=null;
        LLVMParser.identifier_return identifier183 = null;


        CommonTree string_literal181_tree=null;
        CommonTree string_literal182_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:438:42: ( 'br' 'label' identifier )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/llvm/parser/LLVM.g:439:3: 'br' 'label' identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal181=(Token)match(input,102,FOLLOW_102_in_uncondBranchInstr2358); 
            string_literal181_tree = (CommonTree)adaptor.create(string_literal181);
            adaptor.addChild(root_0, string_literal181_tree);

            string_literal182=(Token)match(input,103,FOLLOW_103_in_uncondBranchInstr2360); 
            string_literal182_tree = (CommonTree)adaptor.create(string_literal182);
            adaptor.addChild(root_0, string_literal182_tree);

            pushFollow(FOLLOW_identifier_in_uncondBranchInstr2362);
            identifier183=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier183.getTree());
             retval.inst = new LLUncondBranchInstr(helper.getSymbolOp((identifier183!=null?identifier183.theId:null), null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "uncondBranchInstr"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\15\uffff";
    static final String DFA2_eofS =
        "\15\uffff";
    static final String DFA2_minS =
        "\1\4\1\30\3\5\4\uffff\1\32\3\uffff";
    static final String DFA2_maxS =
        "\1\27\1\31\3\5\4\uffff\1\65\3\uffff";
    static final String DFA2_acceptS =
        "\5\uffff\1\6\1\7\1\1\1\2\1\uffff\1\3\1\5\1\4";
    static final String DFA2_specialS =
        "\15\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\6\2\uffff\1\2\1\3\1\4\4\uffff\1\5\10\uffff\1\1",
            "\1\7\1\10",
            "\1\11",
            "\1\11",
            "\1\11",
            "",
            "",
            "",
            "",
            "\1\12\12\uffff\1\14\2\13\16\14",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "56:1: directive : ( targetDataLayoutDirective ( NEWLINE | EOF ) | targetTripleDirective ( NEWLINE | EOF ) | typeDefinition ( NEWLINE | EOF ) | globalDataDirective ( NEWLINE | EOF ) | constantDirective ( NEWLINE | EOF ) | defineDirective ( NEWLINE | EOF ) | NEWLINE );";
        }
    }
 

    public static final BitSet FOLLOW_toplevelstmts_in_prog69 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_prog71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_directive_in_toplevelstmts101 = new BitSet(new long[]{0x0000000000804392L});
    public static final BitSet FOLLOW_targetDataLayoutDirective_in_directive122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_set_in_directive124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_targetTripleDirective_in_directive137 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_set_in_directive140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDefinition_in_directive152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_set_in_directive155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_globalDataDirective_in_directive167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_set_in_directive170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constantDirective_in_directive182 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_set_in_directive184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defineDirective_in_directive196 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_set_in_directive198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_directive210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_targetDataLayoutDirective223 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_targetDataLayoutDirective225 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUALS_in_targetDataLayoutDirective227 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_stringLiteral_in_targetDataLayoutDirective229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_targetTripleDirective245 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_targetTripleDirective247 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUALS_in_targetTripleDirective249 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_stringLiteral_in_targetTripleDirective251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_typeDefinition266 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUALS_in_typeDefinition268 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_typeDefinition270 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_type_in_typeDefinition274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inttype_in_type327 = new BitSet(new long[]{0x0000000410000002L});
    public static final BitSet FOLLOW_structtype_in_type338 = new BitSet(new long[]{0x0000000410000002L});
    public static final BitSet FOLLOW_arraytype_in_type348 = new BitSet(new long[]{0x0000000410000002L});
    public static final BitSet FOLLOW_27_in_type356 = new BitSet(new long[]{0x0000000410000002L});
    public static final BitSet FOLLOW_symboltype_in_type373 = new BitSet(new long[]{0x0000000410000002L});
    public static final BitSet FOLLOW_28_in_type390 = new BitSet(new long[]{0x0000000410000002L});
    public static final BitSet FOLLOW_paramstype_in_type402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_TYPE_in_inttype424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_structtype443 = new BitSet(new long[]{0x00000000E80003C0L});
    public static final BitSet FOLLOW_typeList_in_structtype445 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_structtype447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_arraytype468 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_number_in_arraytype470 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_arraytype472 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_type_in_arraytype474 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_arraytype476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_paramstype494 = new BitSet(new long[]{0x00000008A80003C0L});
    public static final BitSet FOLLOW_typeList_in_paramstype496 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_paramstype498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeList540 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_typeList558 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_type_in_typeList562 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_identifier_in_symboltype604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_globalDataDirective618 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUALS_in_globalDataDirective620 = new BitSet(new long[]{0x003FFF2000000000L});
    public static final BitSet FOLLOW_linkage_in_globalDataDirective622 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_globalDataDirective625 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_typedconstant_in_globalDataDirective627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_constantDirective641 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUALS_in_constantDirective643 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_addrspace_in_constantDirective645 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_constantDirective648 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_typedconstant_in_constantDirective650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_addrspace671 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_addrspace673 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_number_in_addrspace675 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_addrspace677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_linkage698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typedconstant780 = new BitSet(new long[]{0xFF400000A0002F80L,0x000000000000000FL});
    public static final BitSet FOLLOW_number_in_typedconstant786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_charconst_in_typedconstant793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringconst_in_typedconstant800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structconst_in_typedconstant807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayconst_in_typedconstant814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_symbolconst_in_typedconstant822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_typedconstant830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constcastexpr_in_typedconstant838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_casttype_in_constcastexpr859 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_constcastexpr861 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_typedconstant_in_constcastexpr863 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_constcastexpr865 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_type_in_constcastexpr867 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_constcastexpr869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_casttype907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_casttype915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_casttype923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_casttype931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_casttype939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_casttype947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_casttype955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_casttype963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_casttype971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_casttype979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_casttype988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_casttype996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_symbolconst1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_charLiteral_in_charconst1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cstringLiteral_in_stringconst1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_structconst1103 = new BitSet(new long[]{0x00000000E80003C0L});
    public static final BitSet FOLLOW_typedconstant_in_structconst1108 = new BitSet(new long[]{0x0000001040000000L});
    public static final BitSet FOLLOW_36_in_structconst1118 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_typedconstant_in_structconst1122 = new BitSet(new long[]{0x0000001040000000L});
    public static final BitSet FOLLOW_30_in_structconst1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_arrayconst1181 = new BitSet(new long[]{0x00000002A80003C0L});
    public static final BitSet FOLLOW_typedconstant_in_arrayconst1186 = new BitSet(new long[]{0x0000001200000000L});
    public static final BitSet FOLLOW_36_in_arrayconst1196 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_typedconstant_in_arrayconst1200 = new BitSet(new long[]{0x0000001200000000L});
    public static final BitSet FOLLOW_33_in_arrayconst1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAMED_ID_in_identifier1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNNAMED_ID_in_identifier1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_ID_in_identifier1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_number1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charLiteral1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_stringLiteral1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CSTRING_LITERAL_in_cstringLiteral1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_defineDirective1360 = new BitSet(new long[]{0x003FFF00A80003C0L,0x00000000000FFFF0L});
    public static final BitSet FOLLOW_linkage_in_defineDirective1362 = new BitSet(new long[]{0x00000000A80003C0L,0x00000000000FFFF0L});
    public static final BitSet FOLLOW_visibility_in_defineDirective1365 = new BitSet(new long[]{0x00000000A80003C0L,0x00000000000FFF80L});
    public static final BitSet FOLLOW_cconv_in_defineDirective1368 = new BitSet(new long[]{0x00000000A80003C0L,0x00000000000FF000L});
    public static final BitSet FOLLOW_attrs_in_defineDirective1371 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_type_in_defineDirective1373 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_identifier_in_defineDirective1375 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_arglist_in_defineDirective1377 = new BitSet(new long[]{0x0000000000000010L,0x00000003FFF00000L});
    public static final BitSet FOLLOW_fn_attrs_in_defineDirective1379 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_defineDirective1381 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_defineDirective1400 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_defineDirective1402 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_defineStmts_in_defineDirective1408 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_defineDirective1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_visibility1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_cconv1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_cconv1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_cconv1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_cconv1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_cconv1490 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_number_in_cconv1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attr_in_attrs1531 = new BitSet(new long[]{0x0000000000000002L,0x00000000000FF000L});
    public static final BitSet FOLLOW_set_in_attr0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fn_attr_in_fn_attrs1610 = new BitSet(new long[]{0x0000000000000002L,0x00000003FFF00000L});
    public static final BitSet FOLLOW_84_in_fn_attr1629 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_fn_attr1631 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_number_in_fn_attr1633 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_fn_attr1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_fn_attr1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_fn_attr1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_fn_attr1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_fn_attr1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_fn_attr1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_fn_attr1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_fn_attr1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_fn_attr1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_fn_attr1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_fn_attr1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_fn_attr1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_fn_attr1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_fn_attr1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_arglist1733 = new BitSet(new long[]{0x00000008A80003C0L});
    public static final BitSet FOLLOW_funcarg_in_arglist1746 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_arglist1768 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_funcarg_in_arglist1772 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_arglist1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_funcarg1824 = new BitSet(new long[]{0x0000000000000380L,0x00000000000FF000L});
    public static final BitSet FOLLOW_attrs_in_funcarg1826 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_identifier_in_funcarg1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_defineStmts1868 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_blocklabel_in_block1912 = new BitSet(new long[]{0x0000000000000080L,0x0000007000000000L});
    public static final BitSet FOLLOW_instr_in_block1926 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_block1928 = new BitSet(new long[]{0x0000000000000082L,0x0000007000000000L});
    public static final BitSet FOLLOW_LABEL_in_blocklabel1954 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_blocklabel1956 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_blocklabel1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_allocaInstr_in_instr1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_storeInstr_in_instr2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_branchInstr_in_instr2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_uncondBranchInstr_in_instr2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retInstr_in_instr2065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNNAMED_ID_in_ret2101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAMED_ID_in_local2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_local_in_allocaInstr2152 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUALS_in_allocaInstr2154 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_allocaInstr2156 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_type_in_allocaInstr2158 = new BitSet(new long[]{0x00000000A80003C2L});
    public static final BitSet FOLLOW_typedconstant_in_allocaInstr2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typedconstant_in_typedop2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_storeInstr2208 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_typedop_in_storeInstr2212 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_storeInstr2214 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_typedop_in_storeInstr2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_retInstr2244 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_27_in_retInstr2250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typedop_in_retInstr2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_branchInstr2315 = new BitSet(new long[]{0x00000000A80003C0L});
    public static final BitSet FOLLOW_typedop_in_branchInstr2317 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_branchInstr2319 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_branchInstr2321 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_identifier_in_branchInstr2325 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_branchInstr2327 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_branchInstr2329 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_identifier_in_branchInstr2333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_uncondBranchInstr2358 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_uncondBranchInstr2360 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_identifier_in_uncondBranchInstr2362 = new BitSet(new long[]{0x0000000000000002L});

}