/*******************************************************************************

INTEL CORPORATION PROPRIETARY INFORMATION
This software is supplied under the terms of a license agreement or nondisclosure
agreement with Intel Corporation and may not be copied or disclosed except in
accordance with the terms of that agreement
Copyright(c) 2013 Intel Corporation. All Rights Reserved.

*******************************************************************************/
package intel.pcsdk;

import intel.pcsdk.PXCMFaceAnalysis.*;
import intel.pcsdk.PXCMGesture.*;
import java.lang.System.*;

public class PXCUPipelineJNI {
	public static int GESTURE=0x00000002;
	public static int FACE_LOCATION=0x00000004;
	public static int FACE_LANDMARK=0x00000008;
	public static int COLOR_VGA=0x00000001;
	public static int COLOR_WXGA=0x00000010;
	public static int DEPTH_QVGA=0x00000020;
    public static int VOICE_RECOGNITION=0x00000040;

	private long  instance;
    private boolean initialized;

	static {
		if (System.getProperty("os.arch").compareTo("x86")==0) 
			System.loadLibrary("libpxcupipeline-jni-Win32");
		else
			System.loadLibrary("libpxcupipeline-jni-x64");
	}

	private native static long CreateC();
	public PXCUPipelineJNI() {
        initialized=false;
		instance=CreateC();
	}  

	private native static void DestroyC(long inst);
	public void dispose() {
        Close();
        if (instance!=0) {
			DestroyC(instance);
            instance=0;
        }
	}

	private native static boolean InitC(long inst,int mode);
	public boolean Init(int mode) {
        if (instance==0) return false;
		initialized=InitC(instance,mode);
		return initialized;
	}
	
    private native static void CloseC(long inst);
	public void Close() {
        if (initialized && instance!=0)
			CloseC(instance);
        initialized=false;
	}
  
    private native static boolean AcquireFrameC(long inst,boolean wait);
	public boolean AcquireFrame(boolean wait) {
		if (!initialized) return false;
		return AcquireFrameC(instance,wait);
	}

    private native static boolean IsDisconnectedC(long inst);
	public boolean IsDisconnected() {
		if (!initialized) return false;
		return IsDisconnectedC(instance);
	}
    
    private native static boolean QueryRGBSizeC(long inst,int[] size);
	public boolean QueryRGBSize(int[] size) {
		if (!initialized) return false;
		return QueryRGBSizeC(instance,size);
	}
  
    private native static boolean QueryRGBC(long inst,int[] image);
	public boolean QueryRGB(int[] image) {
		if (!initialized || image==null) return false;
		return QueryRGBC(instance,image);
	}
  
    private native static boolean QueryDepthMapSizeC(long inst,int[] size);
	public boolean QueryDepthMapSize(int[] size) {
		if (!initialized) return false;
		return QueryDepthMapSizeC(instance,size);
	}
  
	private native static boolean QueryDepthMapC(long inst,short[] depthMap);
	public boolean QueryDepthMap(short[] depthMap) {
		if (!initialized) return false;
		return QueryDepthMapC(instance,depthMap);
	}

    private native static boolean QueryIRMapSizeC(long inst,int[] size);
	public boolean QueryIRMapSize(int[] size) {
		if (!initialized) return false;
		return QueryIRMapSizeC(instance,size);
	}
  
    public native static boolean QueryIRMapC(long inst,short[] irmap);
	public boolean QueryIRMap(short[] irmap) {
		if (!initialized || irmap==null) return false;
		return QueryIRMapC(instance,irmap);
	}
  
    private native static boolean QueryUVMapSizeC(long inst,int[] size);
	public boolean QueryUVMapSize(int[] size) {
		if (!initialized) return false;
		return QueryUVMapSizeC(instance,size);
	}
  
    private native static boolean QueryUVMapC(long inst,float[] uvmap);
	public boolean QueryUVMap(float[] uvmap) {
		if (!initialized) return false;
		return QueryUVMapC(instance,uvmap);
	}

    private native static boolean QueryLabelMapSizeC(long inst,int[] size);
	public boolean QueryLabelMapSize(int[] size) {
		if (!initialized) return false;
		return QueryLabelMapSizeC(instance,size);
	}
  
    private native static boolean QueryLabelMapC(long inst,byte[] labelmap, int[] labels);
	public boolean QueryLabelMap(byte[] labelMap,int[] labels) {
		if (!initialized) return false;
		return QueryLabelMapC(instance,labelMap,labels);
	}

	private native static boolean QueryGeoNodeC(long inst,int body,GeoNode data);
	public boolean QueryGeoNode(int body,GeoNode data) {
		if (!initialized) return false;
		return QueryGeoNodeC(instance,body,data);
	}

	public boolean QueryGeoNode(int body, GeoNode[] data) {
		if (!initialized) return false;
		boolean found=false;
		for (int i=0;i<data.length;i++,body++)
			if (QueryGeoNode(body,data[i])) found=true;
		return found;
	}

	private native static boolean QueryGestureC(long inst,int body,Gesture data);
	public boolean QueryGesture(int body,Gesture data) {
		if (!initialized) return false;
		return QueryGestureC(instance,body,data);
	}

    private native static boolean QueryFaceIDC(long inst,int fidx,long[] data);
	public boolean QueryFaceID(int fidx, long[] data) {
		if (!initialized) return false;
		return QueryFaceIDC(instance,fidx,data);
	}

	private native static boolean QueryFaceLocationDataC(long inst,int face, Detection.Data data);
	public boolean QueryFaceLocationData(int face, Detection.Data data) {
		if (!initialized) return false;
		return QueryFaceLocationDataC(instance,face,data);
	}
  
	private native static boolean QueryFaceLandmarkPoseC(long inst,int face,Landmark.PoseData data);
	public boolean QueryFaceLandmarkPose(int face, Landmark.PoseData data) {
		if (!initialized) return false;
		return QueryFaceLandmarkPoseC(instance,face,data);
	}
  
	private native static boolean QueryFaceLandmarkDataC(long inst,int face,int label,int idx,Landmark.LandmarkData data);
	public boolean QueryFaceLandmarkData(int face, int label, int idx, Landmark.LandmarkData data) {
		if (!initialized) return false;
		return QueryFaceLandmarkDataC(instance,face,label,idx,data);
	}

	public boolean QueryFaceLandmarkData(int face, int label, Landmark.LandmarkData[] data) {
		if (!initialized) return false;
		int size=data.length;
		boolean detected=false;
		for (int i=0;i<data.length;i++)
			if (QueryFaceLandmarkData(face,label,i,data[i])) detected=true;
		return detected;
	}

	private native static void ReleaseFrameC(long inst);
	public void ReleaseFrame() {
		if (!initialized) return;
		ReleaseFrameC(instance);
	}

    private native static boolean QueryDevicePropertyC(long inst,int pty,float[] data);
	public boolean QueryDeviceProperty(int pty, float[] data) {
		if (!initialized) return false;
		return QueryDevicePropertyC(instance,pty,data);
	}

	private native static boolean SetDevicePropertyC(long inst,int pty,float[] data);
	public boolean SetDeviceProperty(int pty, float[] data) {
		if (!initialized) return false;
		return SetDevicePropertyC(instance,pty,data);
	}

    private native static void SetVoiceCommandsC(long inst,String[] str);
    public void SetVoiceCommands(String[] str) {
        if (instance==0) return;
		SetVoiceCommandsC(instance,str);
    }

	private native static void SetVoiceDictationC(long inst);
    public void SetVoiceDictation() {
        if (instance==0) return;
		SetVoiceDictationC(instance);
    }

    private native static boolean QueryVoiceRecognizedC(long inst,PXCMVoiceRecognition.Recognition data);
    public boolean QueryVoiceRecognized(PXCMVoiceRecognition.Recognition data) {
		if (!initialized) return false;
		return QueryVoiceRecognizedC(instance,data);
    }

    private native static void PauseFrameC(long inst,int mode,boolean pause);
    public void PauseFrame(int mode, boolean pause) {
		if (!initialized) return;
		PauseFrameC(instance,mode,pause);
    }
}

