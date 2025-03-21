function DoctorCard() {
    return (
        <div>
            <div className="max-w-4xl mx-auto py-2">
                <div className="bg-white p-6 rounded-lg shadow-md mb-6 flex items-center">
                    <img alt="Doctor Nguyễn Đức Bằng" className="w-24 h-24 rounded-full mr-6" src="https://placehold.co/100x100" />
                    <div className="flex-1">
                        <h2 className="text-xl font-semibold">
                            TS. BS Nguyễn Đức Bằng
                        </h2>
                        <span className="inline-block bg-gray-200 text-gray-700 text-sm px-2 py-1 rounded-full mt-2">
                            Hô hấp
                        </span>
                        <p className="text-gray-600 mt-2">
                            Số 005 Chung cư Ngô Quyền, Phường 9, Quận 5, Hồ Chí Minh
                        </p>
                    </div>
                    <button className="bg-blue-500 text-white px-4 py-2 rounded-lg">
                        Đặt khám
                    </button>
                </div>
            </div>
        </div>
    );
}

export default DoctorCard;