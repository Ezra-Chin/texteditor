// Generated from edu/curtin/texteditor/keymap/Keymap.g4 by ANTLR 4.13.2
package edu.curtin.texteditor.keymap;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KeymapParser}.
 */
public interface KeymapListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KeymapParser#keymap}.
	 * @param ctx the parse tree
	 */
	void enterKeymap(KeymapParser.KeymapContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#keymap}.
	 * @param ctx the parse tree
	 */
	void exitKeymap(KeymapParser.KeymapContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(KeymapParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(KeymapParser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#threekeys}.
	 * @param ctx the parse tree
	 */
	void enterThreekeys(KeymapParser.ThreekeysContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#threekeys}.
	 * @param ctx the parse tree
	 */
	void exitThreekeys(KeymapParser.ThreekeysContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(KeymapParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(KeymapParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(KeymapParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(KeymapParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#position}.
	 * @param ctx the parse tree
	 */
	void enterPosition(KeymapParser.PositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#position}.
	 * @param ctx the parse tree
	 */
	void exitPosition(KeymapParser.PositionContext ctx);
}