/*
 * Copyright (c) 2012, Finn Kuusisto
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *     
 *     Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package kuusisto.tinysound.internal;

import kuusisto.tinysound.OnStopListener;

/**
 * The MusicReference interface is the Mixer's interface to the audio data of a
 * Music object.  MusicReference is an internal interface of the TinySound
 * system and should be of no real concern to the average user of TinySound.
 *
 * @author Finn Kuusisto
 */
public interface MusicReference {

	/**
	 * Get the playing setting of this MusicReference.
	 * @return true if this MusicReference is set to play
	 */
	public boolean getPlaying();

	/**
	 * Set whether this MusicReference is playing.
	 * @param playing whether this MusicReference is playing
	 */
	public void setPlaying(boolean playing);

	/**
	 * Get the loop setting of this MusicReference.
	 * @return true if this MusicReference is set to loop
	 */
	public boolean getLoop();

	/**
	 * Set whether this MusicReference will loop.
	 * @param loop whether this MusicReference will loop
	 */
	public void setLoop(boolean loop);

	/**
	 * Get the byte index of this MusicReference.
	 * @return byte index of this MusicReference
	 */
	public long getPosition();

	/**
	 * Set the byte index of this MusicReference.
	 * @param position the byte index to set
	 */
	public void setPosition(long position);

	/**
	 * Get the loop-position byte index of this MusicReference.
	 * @return loop-position byte index of this MusicReference
	 */
	public long getLoopPosition();

	/**
	 * Set the loop-position byte index of this MusicReference.
	 * @param loopPosition the loop-position byte index to set
	 */
	public void setLoopPosition(long loopPosition);

	/**
	 * Get the volume of this MusicReference.
	 * @return volume of this MusicReference
	 */
	public double getVolume();

	/**
	 * Set the volume of this MusicReference.
	 * @param volume the desired volume of this MusicReference
	 */
	public void setVolume(double volume);

	/**
	 * Get the pan of this MusicReference.
	 * @return pan of this MusicReference
	 */
	public double getPan();

	/**
	 * Set the pan of this MusicReference.  Must be between -1.0 (full pan left)
	 * and 1.0 (full pan right).
	 * @param pan the desired pan of this MusicReference
	 */
	public void setPan(double pan);

	/**
	 * Get the number of bytes remaining for each channel until the end of this
	 * Music.
	 * @return number of bytes remaining for each channel
	 */
	public long bytesAvailable();

	/**
	 * Determine if there are no bytes remaining and play has stopped.
	 * @return true if there are no bytes remaining and the reference is no
	 * longer playing
	 */
	public boolean done();

	/**
	 * Skip a specified number of bytes of the audio data.
	 * @param num number of bytes to skip
	 */
	public void skipBytes(long num);

	/**
	 * Get the next two bytes from the music data in the specified endianness.
	 * @param data length-2 array to write in next two bytes from each channel
	 * @param bigEndian true if the bytes should be read big-endian
	 */
	public void nextTwoBytes(int[] data, boolean bigEndian);

	/**
	 * Does any cleanup necessary to dispose of resources in use by this
	 * MusicReference.
	 */
	public void dispose();

	public void setOnStopListener(OnStopListener listener);

}
