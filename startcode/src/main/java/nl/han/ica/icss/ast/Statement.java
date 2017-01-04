package nl.han.ica.icss.ast;

/**
 * A statement is the common name for the actual content of ICSS stylesheets
 * Statements can be RuleSets, Assignments or Declarations
 *
 */
public abstract class Statement {
    String test = "test";
    RuleSet ruleSet = null;
    Assignment assignment = null;
    Declaration declaration = null;


}
