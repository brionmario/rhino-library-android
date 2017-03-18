package com.apareciumlabs.brionsilva.rhino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

/**
 * This class can be used to evaluate any string expression using the open source,
 * RHINO javascript engine.
 *
 * Add this line - compile 'org.mozilla:rhino:1.7R4'
 * To your module app dependency gradle to install the jar library.
 *
 * Follow my tutorial at
 * {@link} https://github.com/brionsilva/Android-Rhino-Example
 *
 * @author  Brion Mario
 * @version 1.0
 * @since   2017-03-08
 */

public class EvaluateEngine {

    private Context rhino;
    private Scriptable scope;

    Double answer;


    /**
     * This function evaluates the string when it is passed as a parameter.
     *
     * @param question The expression is passed to the method
     * @return Returns the evaluated answer in a double variable
     */
    public Double evaluate (String question) {

            Object[] functionParams = new Object[]{question};

            //The js function
            String script = "function evaluate(arithmetic){  return eval(arithmetic)    ;} ";

            Context rhino = Context.enter();

            //disabling the optimizer to better support Android.
            rhino.setOptimizationLevel(-1);

            try {

                Scriptable scope = rhino.initStandardObjects();

                /**
                 * evaluateString(Scriptable scope, java.lang.String source, java.lang.String sourceName,
                 * int lineno, java.lang.Object securityDomain)
                 *
                 */
                rhino.evaluateString(scope, script , "JavaScript", 1, null);


                Function function = (Function) scope.get("evaluate", scope);


                answer = (Double) function.call(rhino, scope, scope, functionParams);


            } catch (RhinoException e) {

                e.printStackTrace();

            } finally {
                Context.exit();
            }

    return answer;
    }
}
