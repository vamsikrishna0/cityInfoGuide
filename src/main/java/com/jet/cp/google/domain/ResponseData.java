package com.jet.cp.google.domain;

import java.util.List;

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
