import {DoctorSearchResponse} from "../types/DoctorSearchResponse.ts";
import {useEffect, useMemo, useState} from "react";
import DoctorItemCard, {DoctorCardProps} from "../components/DoctorItemCard.tsx";
import {DoctorRepository} from "../repository/DocktorRepository.ts";
import {useNavigate} from "react-router-dom";

function DoctorList() {
    const [dropdownOpen, setDropdownOpen] = useState(false);
    const [selectedCategory, setSelectedCategory] = useState("Loại");
    const [keyword, setKeyword] = useState("");
    const [doctors, setDoctors] = useState<DoctorCardProps[]>([]);
    const categories = [{name: "Tai nạn", value: "accident"}, {name: "Triệu chứng", value: "symptom"}];
    const [searchType, setSearchType] = useState<string>("symptom");
    const doctorRepository = useMemo(() => new DoctorRepository(), []);
    const navigate = useNavigate();

    const fetchDoctors = async (searchKeyword: string) => {
        try {
            const response =
                searchType === "symptom"
                    ? await doctorRepository.searchDoctorBySymptom(searchKeyword)
                    : await doctorRepository.searchDoctorByAccident(searchKeyword);

            setDoctors(
                response.result.map((doctor: DoctorSearchResponse) => ({
                    id: doctor.id,
                    name: doctor.name,
                    hospital: doctor.hospital,
                    specialty: doctor.specialization,
                    price: doctor.price,
                    consultations: doctor.visits,
                    rating: doctor.rating,
                    imageUrl: doctor.thumbnail,
                }))
            );
        } catch (error) {
            console.error("Lỗi khi tìm kiếm bác sĩ:", error);
            setDoctors([]);
        }
    };

    const handleSearch = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        navigate(`/search?keyword=${encodeURIComponent(keyword)}&type=${searchType}`);
    };

    useEffect(() => {
        fetchDoctors(" ");
    }, [searchType]);

    return (
        <div className="max-w-4xl mx-auto">
            <form className="mb-6" onSubmit={handleSearch}>
                <div className="flex relative">
                    {/* Dropdown */}
                    <button
                        type="button"
                        className="shrink-0 z-10 inline-flex items-center py-2.5 px-4 text-sm font-medium text-gray-900 bg-gray-100 border border-gray-300 rounded-s-lg hover:bg-gray-200"
                        onClick={() => setDropdownOpen(!dropdownOpen)}
                    >
                        {selectedCategory}
                        <svg className="w-2.5 h-2.5 ms-2.5" viewBox="0 0 10 6" fill="none">
                            <path
                                stroke="currentColor"
                                strokeLinecap="round"
                                strokeLinejoin="round"
                                strokeWidth="2"
                                d="m1 1 4 4 4-4"
                            />
                        </svg>
                    </button>

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
                                                setSearchType(category.value);
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
                            onChange={(e) => setKeyword(e.target.value)}
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

            {/* Hiển thị danh sách bác sĩ (chỉ lấy 4 bác sĩ đầu tiên) */}
            {doctors.length > 0 ? (
                <div className="grid grid-cols-1 md:grid-cols-4 gap-6">
                    {doctors.slice(0, 4).map((doctor, index) => (
                        <DoctorItemCard key={index} {...doctor} />
                    ))}
                </div>
            ) : (
                <p className="text-center text-gray-500">Không tìm thấy kết quả.</p>
            )}
        </div>
    );
}

export default DoctorList;
