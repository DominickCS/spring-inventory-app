package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("In House Part")
public class InhousePart extends Part {
  int partId;

  public InhousePart() {
  }

  public int getPartId() {
    return partId;
  }

  public void setPartId(int partId) {
    this.partId = partId;
  }
}
