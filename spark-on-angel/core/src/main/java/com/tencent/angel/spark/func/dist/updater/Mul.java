package com.tencent.angel.spark.func.dist.updater;

import com.tencent.angel.ps.impl.matrix.ServerDenseDoubleRow;

import java.nio.DoubleBuffer;

public class Mul extends V3UpdaterFunc {

  public Mul(int matrixId, int fromId1, int fromId2, int toId) {
    super(matrixId, fromId1, fromId2, toId);
  }

  public Mul() {
    super();
  }

  @Override
  protected void doUpdate(
      ServerDenseDoubleRow fromRow1, ServerDenseDoubleRow fromRow2, ServerDenseDoubleRow toRow) {
    DoubleBuffer from1 = fromRow1.getData();
    DoubleBuffer from2 = fromRow2.getData();
    DoubleBuffer to = toRow.getData();
    int size = fromRow1.size();
    for (int i = 0; i < size; i++) {
      to.put(i, from1.get(i) * from2.get(i));
    }
  }

}