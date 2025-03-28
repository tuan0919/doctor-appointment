import {useEffect, useMemo, useState} from "react";
import DoctorItemCard, {DoctorCardProps} from "../components/DoctorItemCard.tsx";

import {DoctorRepository} from "../repository/DocktorRepository.ts";
import {DoctorSearchResponse} from "../types/DoctorSearchResponse.ts";


const Search = () => {
    const [dropdownOpen, setDropdownOpen] = useState(false);
    const [selectedCategory, setSelectedCategory] = useState("Triệu chứng");
    const [keyword, setKeyword] = useState("");
    const [doctors, setDoctors] = useState<DoctorCardProps[]>([]);
    const [currentPage, setCurrentPage] = useState(1);
    const doctorsPerPage = 6; // 2 hàng, 3 cột

    const categories = [{name: "Tai nạn", value: "accident"}, {name: "Triệu chứng", value: "symptom"}];
    const [searchType, setSearchType] = useState<string>("symptom");
    const doctorRepository = useMemo(() => {
        return new DoctorRepository();
    }, []);

    // // Xử lý tìm kiếm
    // const handleSearch = async (event: React.FormEvent<HTMLFormElement>) => {
    //     event.preventDefault();
    //     const response =
    //         searchType === 'symptom' ?
    //             await doctorRepository.searchDoctorBySymptom(keyword) :
    //             await doctorRepository.searchDoctorByAccident(keyword);
    //     console.log(`Kết quả search ${selectedCategory} theo từ khóa ${keyword}:`);
    //     console.log(response.result)
    //     setDoctors(response.result.map((doctor: DoctorSearchResponse) => ({
    //         name: doctor.name,
    //         hospital: doctor.hospital,
    //         specialty: doctor.specialization,
    //         price: doctor.price,
    //         consultations: doctor.visits,
    //         rating: doctor.rating,
    //         imageUrl: doctor.thumbnail,
    //     })));
    // }

    const fetchDoctors = async (searchKeyword: string) => {
        try {
            const response =
                searchType === 'symptom'
                    ? await doctorRepository.searchDoctorBySymptom(searchKeyword)
                    : await doctorRepository.searchDoctorByAccident(searchKeyword);

            setDoctors(response.result.map((doctor: DoctorSearchResponse) => ({
                id: doctor.id,
                name: doctor.name,
                hospital: doctor.hospital,
                specialty: doctor.specialization,
                price: doctor.price,
                consultations: doctor.visits,
                rating: doctor.rating,
                imageUrl: doctor.thumbnail,
            })));
        } catch (error) {
            console.error("Lỗi khi tìm kiếm bác sĩ:", error);
            setDoctors([]);
        }
    };

    const handleSearch = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        await fetchDoctors(keyword.trim() === "" ? " " : keyword);
    };

    // ✅ Fetch mặc định khi vừa vào trang
    useEffect(() => {
        fetchDoctors(" ");
    }, [searchType]); // Khi đổi loại search cũng fetch lại luôn


    // Lấy danh sách bác sĩ theo trang
    const indexOfLastDoctor = currentPage * doctorsPerPage;
    const indexOfFirstDoctor = indexOfLastDoctor - doctorsPerPage;
    const currentDoctors = doctors.slice(indexOfFirstDoctor, indexOfLastDoctor);

    return (
            <div className="max-w-4xl mx-auto">
                <form className="mb-6" onSubmit={handleSearch}>
                    <div className="flex relative">
                        {/* Dropdown Button */}
                        <button
                            type="button"
                            className="shrink-0 z-10 inline-flex items-center py-2.5 px-4 text-sm font-medium text-gray-900 bg-gray-100 border border-gray-300 rounded-s-lg hover:bg-gray-200"
                            onClick={() => setDropdownOpen(!dropdownOpen)}
                        >
                            {selectedCategory}
                            <svg
                                className="w-2.5 h-2.5 ms-2.5"
                                viewBox="0 0 10 6"
                                fill="none"
                            >
                                <path
                                    stroke="currentColor"
                                    strokeLinecap="round"
                                    strokeLinejoin="round"
                                    strokeWidth="2"
                                    d="m1 1 4 4 4-4"
                                />
                            </svg>
                        </button>

                        {/* Dropdown List */}
                        {dropdownOpen && (
                            <div className="absolute top-full left-0 mt-1 z-10 bg-white rounded-lg shadow-sm w-44">
                                <ul className="py-2 text-sm text-gray-700">
                                    {categories.map((category) => (
                                        <li key={category.value}>
                                            <button
                                                type="button"
                                                className="inline-flex w-full px-4 py-2 hover:bg-gray-100"
                                                onClick={() => {
                                                    setSelectedCategory(category.name);
                                                    setSearchType(category.value)
                                                    setDropdownOpen(false);
                                                }}
                                            >
                                                {category.name}
                                            </button>
                                        </li>
                                    ))}
                                </ul>
                            </div>
                        )}

                        {/* Input Search */}
                        <div className="relative w-full">
                            <input
                                type="search"
                                className="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-e-lg border border-gray-300"
                                placeholder="Nhập từ khóa tìm kiếm..."
                                value={keyword}
                                onChange={(e) => {
                                    console.log("Value nhập vào:", e.target.value);
                                    setKeyword(e.target.value);
                                }} // Sửa lại thành e.target.value
                                required
                            />
                            <button
                                type="submit"
                                className="absolute top-0 end-0 p-2.5 text-sm font-medium h-full text-white bg-blue-700 rounded-e-lg"
                            >
                                🔍
                            </button>
                        </div>
                    </div>
                </form>

                {/* Hiển thị danh sách bác sĩ theo lưới 2 hàng, 3 cột */}
                {currentDoctors.length > 0 ? (
                    <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
                        {currentDoctors.map((doctor, index) => (
                            <DoctorItemCard key={index} {...doctor} />
                        ))}
                    </div>
                ) : (
                    <p className="text-center text-gray-500">Không tìm thấy kết quả.</p>
                )}
                {/* Phân trang */}
                {doctors.length > doctorsPerPage && (
                    <div className="flex justify-center mt-6">
                        <button
                            onClick={() => setCurrentPage((prev) => Math.max(prev - 1, 1))}
                            disabled={currentPage === 1}
                            className="px-4 py-2 mx-2 text-white bg-gray-500 rounded-lg disabled:opacity-50"
                        >
                            ⬅️ Trước
                        </button>
                        <span className="px-4 py-2 mx-2 font-bold">{currentPage}</span>
                        <button
                            onClick={() =>
                                setCurrentPage((prev) =>
                                    prev * doctorsPerPage < doctors.length ? prev + 1 : prev
                                )
                            }
                            disabled={currentPage * doctorsPerPage >= doctors.length}
                            className="px-4 py-2 mx-2 text-white bg-gray-500 rounded-lg disabled:opacity-50"
                        >
                            Tiếp ➡️
                        </button>
                    </div>
                )}
            </div>
        
    );
};

export default Search;
