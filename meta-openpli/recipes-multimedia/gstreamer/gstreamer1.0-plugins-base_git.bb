DEFAULT_PREFERENCE = "1"

include gstreamer1.0-plugins-base.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=c54ce9345727175ff66d17b67ff51f58 \
                    file://COPYING.LIB;md5=6762ed442b3822387a51c92d928ead0d \
                   "

S = "${WORKDIR}/git"

SRCREV = "7de6b06adeb31539f97cac20eaad2d22aaa38bc4"
SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-base;branch=master"
SRC_URI += " \
	file://get-caps-from-src-pad-when-query-caps.patch \
	file://taglist-not-send-to-down-stream-if-all-the-frame-cor.patch \
	file://0001-riff-media-added-fourcc-to-all-mpeg4-video-caps.patch \
	file://0001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-ca.patch \
	file://subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
	"

inherit gitpkgv
PV = "1.7.1+git${SRCPV}"
PKGV = "1.7.1+git${GITPKGV}"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}

