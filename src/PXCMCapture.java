/*******************************************************************************

INTEL CORPORATION PROPRIETARY INFORMATION
This software is supplied under the terms of a license agreement or nondisclosure
agreement with Intel Corporation and may not be copied or disclosed except in
accordance with the terms of that agreement
Copyright(c) 2012 Intel Corporation. All Rights Reserved.

*******************************************************************************/
package intel.pcsdk;

public class PXCMCapture {
	public static class Device {
		/* Single value properties */
		public static int PROPERTY_COLOR_EXPOSURE             =   1;
		public static int PROPERTY_COLOR_BRIGHTNESS           =   2;
		public static int PROPERTY_COLOR_CONTRAST             =   3;
		public static int PROPERTY_COLOR_SATURATION           =   4;
		public static int PROPERTY_COLOR_HUE                  =   5;
		public static int PROPERTY_COLOR_GAMMA                =   6;
		public static int PROPERTY_COLOR_WHITE_BALANCE        =   7;
		public static int PROPERTY_COLOR_SHARPNESS            =   8;
		public static int PROPERTY_COLOR_BACK_LIGHT_COMPENSATION  =   9;
		public static int PROPERTY_COLOR_GAIN                     =   10;
		public static int PROPERTY_AUDIO_MIX_LEVEL            =   100;
		public static int PROPERTY_DEPTH_SATURATION_VALUE	=   200;
		public static int PROPERTY_DEPTH_LOW_CONFIDENCE_VALUE	=   201;
		public static int PROPERTY_DEPTH_CONFIDENCE_THRESHOLD	=   202;
		public static int PROPERTY_DEPTH_SMOOTHING		=   203;
 
		/* Two value properties */
		public static int PROPERTY_COLOR_FIELD_OF_VIEW        =   1000;
		public static int PROPERTY_COLOR_SENSOR_RANGE         =   1002;
		public static int PROPERTY_COLOR_FOCAL_LENGTH         =   1006;
		public static int PROPERTY_COLOR_PRINCIPAL_POINT      =   1008;

		public static int PROPERTY_DEPTH_FIELD_OF_VIEW        =   2000;
		public static int PROPERTY_DEPTH_SENSOR_RANGE         =   2002;
		public static int PROPERTY_DEPTH_FOCAL_LENGTH         =   2006;
		public static int PROPERTY_DEPTH_PRINCIPAL_POINT      =   2008;

		/* Three value properties */
		public static int PROPERTY_ACCELEROMETER_READING      =   3000;

		/* Customized properties */
		public static int PROPERTY_CUSTOMIZED=0x04000000;
	}
}
