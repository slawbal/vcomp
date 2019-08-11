package com.sb.dbspring.ordering.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class AudioBook extends Item {
    private String samplingRate;

    public String getSamplingRate() {
        return this.samplingRate;
    }

    public void setSamplingRate(final String samplingRate) {
        this.samplingRate = samplingRate;
    }
}
