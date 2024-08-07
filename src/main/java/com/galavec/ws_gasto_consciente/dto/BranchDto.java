package com.galavec.ws_gasto_consciente.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BranchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long codBranch;
    private Long codSupermarket;
    private String branchDescription;
    private String branchDirection;
    private String branchCoordinates;
    private String branchHours;
    private String userCreation;
    private LocalDateTime dateCreation;
    private String userModification;
    private LocalDateTime dateModification;
    private String branchStatus;
}
