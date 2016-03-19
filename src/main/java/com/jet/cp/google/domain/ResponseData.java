/**
 * All rights reserved.
 * This software is the confidential and proprietary information
 */
package com.jet.cp.google.domain;

import java.util.List;

/**
 * Title: ResponseData.java<br>
 * Description: <br>
 * Created: 09-Feb-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
public class ResponseData {

  public ResponseData() {
  }

  private List<Results> results;
  /**
   * @return the results
   */
  public List<Results> getResults() {
    return results;
  }

  /**
   * @param results the results to set
   */
  public void setResults(List<Results> results) {
    this.results = results;
  }
}
