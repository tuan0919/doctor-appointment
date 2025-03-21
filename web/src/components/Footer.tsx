function Footer() {
    return (
        <footer className="bg-gray-100 text-gray-700 w-full border-t">
            {/* Top Section */}
            <div className="max-w-6xl mx-auto p-6 grid grid-cols-1 md:grid-cols-5 gap-6">
                {/* Contact Info */}
                <div className="space-y-3">
                    <h2 className="text-xl font-bold text-blue-500">Medpro</h2>
                    <p className="text-sm">
                        Địa chỉ: 236/29/18 Điện Biên Phủ - Phường 17 - Quận Bình Thạnh - TPHCM.<br />
                        Website: <a href="https://medpro.vn" className="text-blue-500 hover:underline" target="_blank" rel="noopener noreferrer">medpro.vn</a><br />
                        Email: <a href="mailto:cskh@medpro.vn" className="text-blue-500 hover:underline">cskh@medpro.vn</a><br />
                        Điện thoại: <span className="text-orange-500 font-semibold">(028) 710 78098</span>
                    </p>
                </div>

                {/* Dịch vụ Y tế */}
                <div className="space-y-3">
                    <h3 className="text-lg font-semibold">Dịch vụ Y tế</h3>
                    <ul className="space-y-2 text-sm">
                        <li><a href="#" className="hover:text-blue-500 transition">Đặt khám tại cơ sở</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Đặt khám bác sĩ</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Gói khám sức khỏe</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Điều dưỡng tại nhà</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Xét nghiệm tại nhà</a></li>
                    </ul>
                </div>

                {/* Cơ sở y tế */}
                <div className="space-y-3">
                    <h3 className="text-lg font-semibold">Cơ sở y tế</h3>
                    <ul className="space-y-2 text-sm">
                        <li><a href="#" className="hover:text-blue-500 transition">Bệnh viện công</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Bệnh viện tư</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Phòng khám</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Phòng mạch</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Xét nghiệm</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Y tế tại nhà</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Tiêm chủng</a></li>
                    </ul>
                </div>

                {/* Hướng dẫn */}
                <div className="space-y-3">
                    <h3 className="text-lg font-semibold">Hướng dẫn</h3>
                    <ul className="space-y-2 text-sm">
                        <li><a href="#" className="hover:text-blue-500 transition">Cài đặt ứng dụng</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Đặt lịch khám</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Tư vấn khám bệnh qua video</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Quy trình hoàn phí</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Câu hỏi thường gặp</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Quy trình đi khám</a></li>
                    </ul>
                </div>

                {/* Về Medpro */}
                <div className="space-y-3">
                    <h3 className="text-lg font-semibold">Về Medpro</h3>
                    <ul className="space-y-2 text-sm">
                        <li><a href="#" className="hover:text-blue-500 transition">Giới thiệu</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Điều khoản dịch vụ</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Chính sách bảo mật</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Quy định sử dụng</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Tham gia Medpro</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Khám sức khỏe doanh nghiệp</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Quảng cáo</a></li>
                        <li><a href="#" className="hover:text-blue-500 transition">Tuyển dụng</a></li>
                    </ul>
                </div>
            </div>

            {/* Bottom Section */}
            <div className="text-center text-sm p-4 bg-gray-200">
                © 2024 Medpro Việt Nam. All rights reserved.
            </div>
        </footer>
    );
}

export default Footer;
