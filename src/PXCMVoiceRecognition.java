/*******************************************************************************

INTEL CORPORATION PROPRIETARY INFORMATION
This software is supplied under the terms of a license agreement or nondisclosure
agreement with Intel Corporation and may not be copied or disclosed except in
accordance with the terms of that agreement
Copyright(c) 2012-2013 Intel Corporation. All Rights Reserved.

*******************************************************************************/
package intel.pcsdk;

public class PXCMVoiceRecognition {
	public static class Recognition {
        public static class NBest {
            public int label;
            public int confidence;

			public NBest(int label1,int confidence1) {
				label=label1;
				confidence=confidence1;
			}
			public NBest() {
				label=confidence=0;
			}
        }

		public long     timeStamp;
        public int      label;
        public int      confidence;
        public NBest[]  nBest;
        public int      duration;
        public String   dictation;
	}
}
