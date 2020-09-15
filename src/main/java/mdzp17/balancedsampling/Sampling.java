package mdzp17.balancedsampling;

import mdzp17.balancedsampling.exceptions.IncorrectProbabilityError;

import java.util.List;
import java.util.function.Function;

/**
 * Class defining functions for sampling
 *
 * @Return List<Object>
 **/
public class Sampling <T>{

    public static <T> List<T> cubeBalancedSampling(Function<T, Double> costFunction, List<T> samplingUnits, List<Double> inclusionProbabilities, List<Double> balancingVariables) throws IncorrectProbabilityError {
        checkIfProbabilitiesFitRules(inclusionProbabilities);
        return null;
    }

    /**
     * Checks that the inclusionProbabilities are correctly defined ( in [0,1] and not null )
     * @param inclusionProbabilities
     * @throws IncorrectProbabilityError
     */
    private static void checkIfProbabilitiesFitRules(List<Double> inclusionProbabilities) throws IncorrectProbabilityError {
        if (inclusionProbabilities.stream().noneMatch(d -> d < 0)) {
            throw new IncorrectProbabilityError("An inclusion probability is less than 0");
        }
        if (inclusionProbabilities.stream().noneMatch(d -> d > 1)) {
            throw new IncorrectProbabilityError("An inclusion probability is greater than 1");
        }
        if (!inclusionProbabilities.contains(null)) {
            throw new IncorrectProbabilityError("There is a null inclusion probability");
        }
    }

    private <T> List<T> flyingStep(Function<T, Double> costFunction, List<T> samplingUnits, List<Double> inclusionProbabilities, List<Double> balancingVariables) {
        List<Double> weightProbabilityVector = inclusionProbabilities;
        List<Double> uT = generateVectorForMatrix(inclusionProbabilities,balancingVariables);
        return samplingUnits;
    }

    private <T> List<T> landingStep(Function<T, Double> costFunction, List<T> samplingUnits, List<Double> inclusionProbabilities, List<Double> balancingVariables) {
        return samplingUnits;
    }

    private List<Double> generateVectorForMatrix(List<Double> inclusionProbabilities, List<Double> balancingVariables){
        return null;
    }

}
