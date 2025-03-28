function Header() {
    return (
        <header className="bg-white shadow-sm max-w">
            {/* Top Section */}
            <div className="max-w-7xl mx-auto flex justify-between items-center p-4">
                {/* Logo */}
                <a href="http://localhost:5173/home">
                    <h1 className="text-3xl font-extrabold text-blue-500 pr-3 whitespace-nowrap">Hi Doctor</h1>
                </a>

                {/* Navigation */}

            </div>

            {/* Support and Navigation Section */}
            <div className="bg-blue-50 w-full">
                <div className="max-w-7xl mx-auto flex justify-center items-center p-4">
                    <a href='http://localhost:5173/search'
                     className='p-2 bg-blue-500 text-white font-semibold rounded-lg shadow hover:bg-blue-600'
                    >Tìm kiếm</a>
                </div>
            </div>
        </header>
    );
}

export default Header;
