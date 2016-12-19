package nl.han.ica.icss.ast;

/**
 * A statement is the common name for the actual content of ICSS stylesheets
 * Statements can be Rulesets, Assignments or Declarations
 *
 */
public abstract class Statement {
    String test = "test";
    Ruleset ruleset = null;
    Assignment assignment = null;
    Declaration declaration = null;


}
