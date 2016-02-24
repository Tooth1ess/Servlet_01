package com.qiu.module;

import java.util.List;

public class JsonResult {
	private int mResultCode;
	private List<GoodsInfo> mGoodsData;

	public int getResultCode() {
		return mResultCode;
	}

	public void setResultCode(int resultCode) {
		mResultCode = resultCode;
	}

	public List<GoodsInfo> getGoodsData() {
		return mGoodsData;
	}

	public void setGoodsData(List<GoodsInfo> goodsData) {
		mGoodsData = goodsData;
	}

}
