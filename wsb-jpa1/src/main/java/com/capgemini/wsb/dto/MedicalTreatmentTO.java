package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.io.Serializable;
import java.util.List;

public class MedicalTreatmentTO implements Serializable {
    private static Long id;
    private static String description;
    private static TreatmentType type;
    private List<VisitTO> visits;

    public List<VisitTO> getVisits() {
        return visits;
    }

    public void setVisits(List<VisitTO> visits) {
        this.visits = visits;
    }

    public static Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static TreatmentType getType() {
        return type;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }
}
