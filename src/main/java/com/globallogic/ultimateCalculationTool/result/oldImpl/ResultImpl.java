package com.globallogic.ultimateCalculationTool.result.oldImpl;

import com.globallogic.ultimateCalculationTool.result.Result;

public class ResultImpl implements Result {
	private Double result;

	@Override
	public Double getResult() {
		return result != null ? result : Double.NaN;
	}

	public void setResult(final Double result) {
		this.result = result;
	}
}
