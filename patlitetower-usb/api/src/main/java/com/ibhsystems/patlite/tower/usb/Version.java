package com.ibhsystems.patlite.tower.usb;

import java.io.Serializable;

public class Version implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int major;
	private final int minor;
	private final int micro;

	Version(int version) {
		this(((version >> 8) & 0xFF), //
				((version >> 4) & 0x0F), //
				(version & 0x0F));
	}

	Version(int major, int minor, int micro) {
		this.major = major;
		this.minor = minor;
		this.micro = micro;
	}

	public int getMajor() {
		return major;
	}

	public int getMinor() {
		return minor;
	}

	public int getMicro() {
		return micro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + major;
		result = prime * result + micro;
		result = prime * result + minor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Version other = (Version) obj;
		if (major != other.major)
			return false;
		if (micro != other.micro)
			return false;
		if (minor != other.minor)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return major + "." + minor + "." + micro;
	}

}
