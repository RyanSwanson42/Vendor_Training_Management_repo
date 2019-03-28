package trm.vt.dao.vendorShortListPtAndVendorDetails;

import trm.vt.dao.vendorDetail.VendorDetail;
import trm.vt.dao.vendorShortListPt.VendorShortListPt;

public class VendorShortListPtAndVendorDetails {

	private VendorShortListPt vslp;
	private VendorDetail vd;
	
	public VendorShortListPt getVslp() {
		return vslp;
	}
	public void setVslp(VendorShortListPt vslp) {
		this.vslp = vslp;
	}
	public VendorDetail getVd() {
		return vd;
	}
	public void setVd(VendorDetail vd) {
		this.vd = vd;
	}
	@Override
	public String toString() {
		return "VendorShortListPtAndVendorDetails [vslp=" + vslp + ", vd=" + vd + "]";
	}
	
}
