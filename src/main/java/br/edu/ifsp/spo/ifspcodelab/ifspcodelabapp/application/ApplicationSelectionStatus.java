package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApplicationSelectionStatus {
    ON_REVIEW,
    NOT_SELECTED,
    SELECTED_AS_VOLUNTEER,
    SELECTED_AS_SCHOLARSHIP;
}
