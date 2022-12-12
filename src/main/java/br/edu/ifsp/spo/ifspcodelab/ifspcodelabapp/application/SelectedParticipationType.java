package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SelectedParticipationType {
    ON_REVIEW,
    NOT_SELECTED,
    VOLUNTEER,
    SCHOLARSHIP;
}
