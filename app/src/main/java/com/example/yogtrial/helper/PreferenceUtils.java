package com.example.yogtrial.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.StringRes;

import com.example.yogtrial.R;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;
import com.google.mlkit.vision.pose.accurate.AccuratePoseDetectorOptions;
import com.google.mlkit.vision.pose.defaults.PoseDetectorOptions;

public class PreferenceUtils {
    private static final int POSE_DETECTOR_PERFORMANCE_MODE_FAST = 1;

    public static PoseDetectorOptionsBase getPoseDetectorOptionsForLivePreview(Context context) {
        int performanceMode =
                getModeTypePreferenceValue(
                        context,
                        R.string.pref_key_live_preview_pose_detection_performance_mode,
                        POSE_DETECTOR_PERFORMANCE_MODE_FAST);
        if (performanceMode == POSE_DETECTOR_PERFORMANCE_MODE_FAST) {
            return new PoseDetectorOptions.Builder()
                    .setDetectorMode(PoseDetectorOptions.STREAM_MODE)
                    .build();
        } else {
            return new AccuratePoseDetectorOptions.Builder()
                    .setDetectorMode(AccuratePoseDetectorOptions.STREAM_MODE)
                    .build();
        }
    }

    public static PoseDetectorOptionsBase getPoseDetectorOptionsForStillImage(Context context) {
        int performanceMode =
                getModeTypePreferenceValue(
                        context,
                        R.string.pref_key_still_image_pose_detection_performance_mode,
                        POSE_DETECTOR_PERFORMANCE_MODE_FAST);
        if (performanceMode == POSE_DETECTOR_PERFORMANCE_MODE_FAST) {
            return new PoseDetectorOptions.Builder()
                    .setDetectorMode(PoseDetectorOptions.SINGLE_IMAGE_MODE)
                    .build();
        } else {
            return new AccuratePoseDetectorOptions.Builder()
                    .setDetectorMode(AccuratePoseDetectorOptions.SINGLE_IMAGE_MODE)
                    .build();
        }
    }

    /**
     * Mode type preference is backed by {@link android.preference.ListPreference} which only support
     * storing its entry value as string type, so we need to retrieve as string and then convert to
     * integer.
     */
    private static int getModeTypePreferenceValue(
            Context context, @StringRes int prefKeyResId, int defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String prefKey = context.getString(prefKeyResId);
        return Integer.parseInt(sharedPreferences.getString(prefKey, String.valueOf(defaultValue)));
    }

    public static boolean shouldShowPoseDetectionInFrameLikelihoodLivePreview(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String prefKey =
                context.getString(R.string.pref_key_live_preview_pose_detector_show_in_frame_likelihood);
        return sharedPreferences.getBoolean(prefKey, true);
    }

    public static boolean shouldShowPoseDetectionInFrameLikelihoodStillImage(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String prefKey =
                context.getString(R.string.pref_key_still_image_pose_detector_show_in_frame_likelihood);
        return sharedPreferences.getBoolean(prefKey, true);
    }

    public static boolean shouldPoseDetectionVisualizeZ(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String prefKey = context.getString(R.string.pref_key_pose_detector_visualize_z);
        return sharedPreferences.getBoolean(prefKey, true);
    }

    public static boolean shouldPoseDetectionRescaleZForVisualization(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String prefKey = context.getString(R.string.pref_key_pose_detector_rescale_z);
        return sharedPreferences.getBoolean(prefKey, true);
    }

    public static boolean shouldPoseDetectionRunClassification(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String prefKey = context.getString(R.string.pref_key_pose_detector_run_classification);
        return sharedPreferences.getBoolean(prefKey, true);
    }

    private PreferenceUtils() {}

}
