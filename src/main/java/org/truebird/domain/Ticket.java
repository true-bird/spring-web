package org.truebird.domain;

import lombok.Data;

@Data
public class Ticket {
    private int tno;
    private String owner;
    private String grade;
}
