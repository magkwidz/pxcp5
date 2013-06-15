/*******************************************************************************

INTEL CORPORATION PROPRIETARY INFORMATION
This software is supplied under the terms of a license agreement or nondisclosure
agreement with Intel Corporation and may not be copied or disclosed except in
accordance with the terms of that agreement
Copyright(c) 2012-2013 Intel Corporation. All Rights Reserved.

*******************************************************************************/
package intel.pcsdk;

public class PXCMFaceAnalysis {
	public static class Detection {
		public static int VIEW_ANGLE_0          = 0x00000001;
		public static int VIEW_ANGLE_45         = 0x00000002;
		public static int VIEW_ANGLE_FRONTAL    = 0x00000004;
		public static int VIEW_ANGLE_135        = 0x00000008;
		public static int VIEW_ANGLE_180        = 0x00000010;
		public static int VIEW_ANGLE_HALF_MULTI = VIEW_ANGLE_FRONTAL | VIEW_ANGLE_45 | VIEW_ANGLE_135;
		public static int VIEW_ANGLE_MULTI      = VIEW_ANGLE_HALF_MULTI | VIEW_ANGLE_0 | VIEW_ANGLE_180;
		public static int VIEW_ANGLE_OMNI       = 0xFFFFFFFF;

		public static class Data {
			public PXCMRectU32 rectangle;
			public int         fid;
			public int         confidence;
			public int         viewAngle;
		}
	}

	public static class Landmark {
		public static int LABEL_LEFT_EYE_OUTER_CORNER   =0x0001000;
        public static int LABEL_LEFT_EYE_INNER_CORNER   =0x0002000;
        public static int LABEL_RIGHT_EYE_OUTER_CORNER  =0x0004000;
        public static int LABEL_RIGHT_EYE_INNER_CORNER  =0x0008000;
        public static int LABEL_MOUTH_LEFT_CORNER       =0x0010000;
        public static int LABEL_MOUTH_RIGHT_CORNER      =0x0020000;
        public static int LABEL_NOSE_TIP                =0x0040000;
        public static int LABEL_6POINTS				    =0x003F006;
        public static int LABEL_7POINTS				    =0x007F007;
		public static int LABEL_SIZE_MASK				=0x0000FFF;

		public static class LandmarkData {
			public PXCMPoint3DF32 position;
			public int   fid;
			public int   label;
			public int   lidx;
		}

		public static class PoseData {
			public int   fid;
			public float yaw;
			public float roll;
			public float pitch;
		}
	}
}
