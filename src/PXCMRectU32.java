/*******************************************************************************

INTEL CORPORATION PROPRIETARY INFORMATION
This software is supplied under the terms of a license agreement or nondisclosure
agreement with Intel Corporation and may not be copied or disclosed except in
accordance with the terms of that agreement
Copyright(c) 2012-2013 Intel Corporation. All Rights Reserved.

*******************************************************************************/
package intel.pcsdk;

public class PXCMRectU32 {
	public int x, y, w, h;

	public PXCMRectU32(int x1, int y1, int w1, int h1) {
		x=x1;
		y=y1;
		w=w1;
		h=h1;
	}

	public PXCMRectU32() {
		x=y=w=h=0;
	}

	@Override public String toString() {
		return "("+x+","+y+",w="+w+",h="+h+")";
	}
}
