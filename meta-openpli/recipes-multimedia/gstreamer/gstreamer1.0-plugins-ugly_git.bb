DEFAULT_PREFERENCE = "1"

include gstreamer1.0-plugins-ugly.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://tests/check/elements/xingmux.c;beginline=1;endline=21;md5=4c771b8af188724855cb99cadd390068 "

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-ugly;branch=master"

S = "${WORKDIR}/git"

SRCREV = "71c3943e5ad1d2f3232061164cf7cfb2ccd052a2"

inherit gitpkgv
PV = "1.8.0+git${SRCPV}"
PKGV = "1.8.0+git${GITPKGV}"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}

