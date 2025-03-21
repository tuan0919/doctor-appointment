function Header() {
    return (
        <header className="bg-white shadow-sm max-w mb-3">
            {/* Top Section */}
            <div className="max-w-7xl mx-auto flex justify-between items-center p-4">
                {/* Logo */}
                <h1 className="text-3xl font-extrabold text-blue-500 pr-3 whitespace-nowrap">medpro</h1>

                {/* Social Media Links & Actions */}
                <div className="flex items-center justify-between w-full text-sm text-gray-600">
                    {/* Left Side: Social Media Links */}
                    <div className="flex items-center space-x-3">
                        <a href="#" className="hover:text-blue-500 transition">Tiktok</a>
                        <span className="text-gray-300">|</span>
                        <a href="#" className="hover:text-blue-500 transition">Zalo</a>
                        <span className="text-gray-300">|</span>
                        <a href="#" className="hover:text-blue-500 transition">Youtube</a>
                    </div>

                    {/* Right Side: Action Buttons */}
                    <div className="flex items-center space-x-3">
                        <button className="bg-orange-500 text-white px-4 py-2 rounded-lg shadow-md hover:bg-orange-600 transition">
                            Tải ứng dụng
                        </button>
                        <button className="border border-blue-500 text-blue-500 px-4 py-2 rounded-lg shadow-md hover:bg-blue-50 transition">
                            Tài khoản
                        </button>
                        <img src="https://flagcdn.com/w320/vn.png" alt="Vietnam Flag" className="w-6 h-4 rounded shadow-sm" />
                    </div>
                </div>
            </div>

            {/* Support and Navigation Section */}
            <div className="bg-blue-50 w-full">
                <div className="max-w-7xl mx-auto flex justify-between items-center p-4">
                    {/* Support Section */}
                    <div className="flex items-center space-x-2">
                        <div className="text-red-500 text-lg">🎧</div>
                        <span className="text-gray-700">Hỗ trợ đặt khám</span>
                        <span className="text-orange-500 font-bold text-lg">1900 2115</span>
                    </div>

                    {/* Navigation Links */}
                    <nav className="flex space-x-6 text-sm font-medium text-gray-700 pr-8">
                        <a href="#" className="hover:text-blue-500 transition">Cơ sở y tế</a>
                        <a href="#" className="hover:text-blue-500 transition">Dịch vụ y tế</a>
                        <a href="#" className="hover:text-blue-500 transition">Khám sức khỏe doanh nghiệp</a>
                        <a href="#" className="hover:text-blue-500 transition">Tin tức</a>
                        <a href="#" className="hover:text-blue-500 transition">Hướng dẫn</a>
                        <a href="#" className="hover:text-blue-500 transition">Liên hệ hợp tác</a>
                    </nav>
                </div>
            </div>
        </header>
    );
}

export default Header;
