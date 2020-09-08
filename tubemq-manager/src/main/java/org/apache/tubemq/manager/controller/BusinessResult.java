package org.apache.tubemq.manager.controller;

import lombok.Data;

/**
 * rest result for business controller
 */
@Data
public class BusinessResult {
    private int state;

    private String msg;
}
