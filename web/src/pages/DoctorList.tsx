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

    useEffect(() => {
        fetchDoctors(" ");
    }, [searchType]);

    return (
        <div className="max-w-4xl mx-auto">

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
// // import DoctorItemCard from "../components/DoctorItemCard.tsx";
// // // import { useEffect, useState } from "react";
// // // import { getDoctors } from "../utils/doctorService.ts";
// // import {doctorsData} from "../data/doctorsData.ts";
//
// export interface DoctorCardProps {
//     id: number;
//     name: string;
//     specialization: string;
//     thumbnail: string;
//     hospital: string | null;
//     ratings: number;
//     price: number;
//     visit: number;
// }
//
//
//
// function DoctorList() {
//     // const [doctors, setDoctors] = useState<DoctorCardProps[]>([]);
//     //
//     // useEffect(() => {
//     //     const fetchDoctors = async () => {
//     //         try {
//     //             const data = await getDoctors();
//     //             setDoctors(data);
//     //         } catch (error) {
//     //             console.error("Failed to fetch doctors:", error);
//     //         }
//     //     };
//     //
//     //     fetchDoctors();
//     // }, []);
//
//     return (
//         <div className="p-4">
//             <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
//                 {/*{doctorsData.map((doctor) => (*/}
//                 {/*    // <DoctorItemCard key={doctor.id} {...doctor} />*/}
//                 {/*))}*/}
//             </div>
//
//         </div>
//     );
// }
//
// export default DoctorList;
