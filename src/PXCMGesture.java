/*******************************************************************************

INTEL CORPORATION PROPRIETARY INFORMATION
This software is supplied under the terms of a license agreement or nondisclosure
agreement with Intel Corporation and may not be copied or disclosed except in
accordance with the terms of that agreement
Copyright(c) 2012-2013 Intel Corporation. All Rights Reserved.

*******************************************************************************/
package intel.pcsdk;

public class PXCMGesture {
	public static class Gesture {
		public static int LABEL_ANY=0;
		public static int LABEL_MASK_SET=(int)0xffff0000;
		public static int LABEL_MASK_DETAILS=0x0000ffff;
		public static int LABEL_SET_HAND=0x00010000;
		public static int LABEL_SET_NAVIGATION=0x00020000;
		public static int LABEL_SET_POSE=0x00040000;
		public static int LABEL_SET_CUSTOMIZED=0x00080000;
		public static int LABEL_NAV_SWIPE_LEFT=LABEL_SET_NAVIGATION+1;
		public static int LABEL_NAV_SWIPE_RIGHT=LABEL_SET_NAVIGATION+2;
		public static int LABEL_NAV_SWIPE_UP=LABEL_SET_NAVIGATION+3;
		public static int LABEL_NAV_SWIPE_DOWN=LABEL_SET_NAVIGATION+4;
		public static int LABEL_HAND_WAVE=LABEL_SET_HAND+1;
		public static int LABEL_HAND_CIRCLE=LABEL_SET_HAND+2;
		public static int LABEL_POSE_THUMB_UP=LABEL_SET_POSE+1;
		public static int LABEL_POSE_THUMB_DOWN=LABEL_SET_POSE+2;
		public static int LABEL_POSE_PEACE=LABEL_SET_POSE+3;
		public static int LABEL_POSE_BIG5=LABEL_SET_POSE+4;

		public long     timeStamp;
		public int      user;
		public int      body;
		public int      label;
		public int      confidence;
		public boolean  active;
	}

	public static class GeoNode {
		public static int LABEL_ANY=0;
		public static int LABEL_MASK_BODY             =(int)0xffffff00;
		public static int LABEL_MASK_DETAILS          =0x000000ff;
		public static int LABEL_BODY_ELBOW_LEFT       =0x00004000;
		public static int LABEL_BODY_ELBOW_RIGHT      =0x00008000;
		public static int LABEL_BODY_HAND_LEFT        =0x00040000;
		public static int LABEL_BODY_HAND_RIGHT       =0x00080000;
		public static int LABEL_BODY_ELBOW_PRIMARY    =0x00004000;
		public static int LABEL_BODY_ELBOW_SECONDARY  =0x00008000;
		public static int LABEL_BODY_HAND_PRIMARY     =0x00040000;
		public static int LABEL_BODY_HAND_SECONDARY   =0x00080000;
		public static int LABEL_FINGER_THUMB          =1;
		public static int LABEL_FINGER_INDEX          =2;
		public static int LABEL_FINGER_MIDDLE	      =3;
		public static int LABEL_FINGER_RING		      =4;
		public static int LABEL_FINGER_PINKY          =5;
		public static int LABEL_HAND_FINGERTIP	      =6;
		public static int LABEL_HAND_UPPER            =7;
		public static int LABEL_HAND_MIDDLE           =8;
		public static int LABEL_HAND_LOWER            =9;
		public static int LABEL_SIDE_ANY              =0;
		public static int LABEL_LEFT                  =1;
		public static int LABEL_RIGHT                 =2;
		public static int LABEL_OPENNESS_ANY          =0;
		public static int LABEL_CLOSE                 =1;
		public static int LABEL_OPEN                  =2;

		public PXCMPoint3DF32 positionWorld;
		public PXCMPoint3DF32 positionImage;
		public long           timeStamp;
		public int            side;
		public int            confidence;
		public int            user;
		public int            body;
		public float          radiusWorld;
		public float          radiusImage;
		public PXCMPoint3DF32 normal;
		public int            openness;
		public int            opennessState;
		public PXCMPoint3DF32 massCenterImage;
		public PXCMPoint3DF32 massCenterWorld;
	}

	public static class Blob {
		public static int LABEL_ANY=0;
		public static int LABEL_SCENE=1;

		public long timeStamp;
		public int  name;
		public int  labelBackground;
		public int  labelLeftHand;
		public int  labelRightHand;
	}
}
