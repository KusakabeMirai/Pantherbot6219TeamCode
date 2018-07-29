package org.firstinspires.ftc.teamcode.Hallib;

/**
 * Created by KusakabeMirai on 6/19/2018.
 */

public class HalUtil
{
    /**
     * This method returns the current time in seconds with nano-second precision.
     *
     * @return current time in seconds.
     */
    public static double getCurrentTime()
    {
        return System.nanoTime()/1000000000.0;
    }   //getCurrentTime

    /**
     * This method returns the current time in msec.
     *
     * @return current time in msec.
     */
    public static long getCurrentTimeMillis()
    {
        return System.currentTimeMillis();
    }   //getCurrentTimeMillis

    /**
     * This method puts the current thread to sleep for the given time in msec.
     * It handles InterruptException where it recalculates the remaining time
     * and calls sleep again repeatedly until the specified sleep time has past.
     *
     * @param sleepTime specifies sleep time in msec.
     */
    public static void sleep(long sleepTime)
    {
        long wakeupTime = System.currentTimeMillis() + sleepTime;

        while (sleepTime > 0)
        {
            try
            {
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e)
            {
            }
            sleepTime = wakeupTime - System.currentTimeMillis();
        }
    }   //sleep

    /**
     * This method clips the given value to the range limited by the given low and high limits.
     *
     * @param value specifies the value to be clipped
     * @param lowLimit specifies the low limit of the range.
     * @param highLimit specifies the high limit of the range.
     * @return the result of the clipped value.
     */
    public static int clipRange(int value, int lowLimit, int highLimit)
    {
        return (value < lowLimit)? lowLimit: (value > highLimit)? highLimit: value;
    }   //clipRange


    /**
     * This method clips the given value to the range limited by the given low and high limits.
     *
     * @param value specifies the value to be clipped
     * @param lowLimit specifies the low limit of the range.
     * @param highLimit specifies the high limit of the range.
     * @return the result of the clipped value.
     */
    public static double clipRange(double value, double lowLimit, double highLimit)
    {
        return (value < lowLimit)? lowLimit: (value > highLimit)? highLimit: value;
    }   //clipRange

    /**
     * This method clips the given value to the range between -1.0 and 1.0.
     *
     * @param value specifies the value to be clipped
     * @return the result of the clipped value.
     */
    public static double clipRange(double value)
    {
        return clipRange(value, -1.0, 1.0);
    }   //clipRange

    /**
     * This method scales the given value from the source range to the target range.
     *
     * @param value specifies the value to be scaled.
     * @param lowSrcRange specifies the low limit of the source range.
     * @param highSrcRange specifies the high limit of the source range.
     * @param lowDstRange specifies the low limit of the target range.
     * @param highDstRange specifies the high limit of the target range
     * @return the result of the scaled value.
     */
    public static int scaleRange(int value, int lowSrcRange, int highSrcRange, int lowDstRange, int highDstRange)
    {
        return lowDstRange + (value - lowSrcRange)*(highDstRange - lowDstRange)/(highSrcRange - lowSrcRange);
    }   //scaleRange

    /**
     * This method scales the given value from the source range to the target range.
     *
     * @param value specifies the value to be scaled.
     * @param lowSrcRange specifies the low limit of the source range.
     * @param highSrcRange specifies the high limit of the source range.
     * @param lowDstRange specifies the low limit of the target range.
     * @param highDstRange specifies the high limit of the target range
     * @return the result of the scaled value.
     */
    public static double scaleRange(
            double value, double lowSrcRange, double highSrcRange, double lowDstRange, double highDstRange)
    {
        return lowDstRange + (value - lowSrcRange)*(highDstRange - lowDstRange)/(highSrcRange - lowSrcRange);
    }   //scaleRange

    /**
     * This method checks if the given value is within the deadband range. If so, it returns 0.0 else it returns
     * the unchanged value.
     *
     * @param value specifies the value to be checked.
     * @param deadband specifies the deadband zone.
     * @return the value 0.0 if within deadband, unaltered otherwise.
     */
    public static double applyDeadband(double value, double deadband)
    {
        return Math.abs(value) >= deadband? value: 0.0;
    }   //applyDeadband

    /**
     * This method combines two bytes into an integer.
     *
     * @param low specifies the low byte.
     * @param high specifies the high byte.
     *
     * @return the converted integer.
     */
    public static int bytesToInt(byte low, byte high)
    {
        return ((int)low & 0xff) | (((int)high & 0xff) << 8);
    }   //bytesToInt

    /**
     * This method converts a byte into an integer.
     *
     * @param data specifies the byte data.
     *
     * @return the converted integer.
     */
    public static int bytesToInt(byte data)
    {
        return bytesToInt(data, (byte)0);
    }   //bytesToInt

    /**
     * This method combines two bytes into a short.
     *
     * @param low specifies the low byte.
     * @param high specifies the high byte.
     *
     * @return the converted short.
     */
    public static short bytesToShort(byte low, byte high)
    {
        return (short)bytesToInt(low, high);
    }   //bytesToShort

} //class HalUtil