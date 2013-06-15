/*******************************************************************************

INTEL CORPORATION PROPRIETARY INFORMATION
This software is supplied under the terms of a license agreement or nondisclosure
agreement with Intel Corporation and may not be copied or disclosed except in
accordance with the terms of that agreement
Copyright(c) 2012-2013 Intel Corporation. All Rights Reserved.

*******************************************************************************/
package intel.pcsdk;

public class PXCMPoint3DF32 {
	public float x, y, z;

	public PXCMPoint3DF32(float x1,float y1,float z1) {
		x=x1;
		y=y1;
		z=z1;
	}

	public PXCMPoint3DF32() {
		x=y=z=0;
	}

	@Override public String toString() {
		return "("+x+","+y+","+z+")";
	}
}        
