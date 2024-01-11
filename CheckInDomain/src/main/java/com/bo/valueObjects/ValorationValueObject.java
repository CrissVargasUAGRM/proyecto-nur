package com.bo.valueObjects;

import com.bo.core.BusinessRuleValidationException;
import com.bo.core.ValueObject;
import com.bo.rules.ValidPointsRule;

public class ValorationValueObject extends ValueObject {
    public int points;

    public int getPoints() {
        return points;
    }

    public ValorationValueObject(int points) throws BusinessRuleValidationException {
        checkRule(new ValidPointsRule(points));
        this.points = points;
    }
}
