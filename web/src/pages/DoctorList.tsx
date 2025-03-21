import DoctorItemCard from "../components/DoctorItemCard.tsx";
// import { useEffect, useState } from "react";
// import { getDoctors } from "../utils/doctorService.ts";
import {doctorsData} from "../data/doctorsData.ts";

export interface DoctorCardProps {
    id: number;
    name: string;
    specialization: string;
    thumbnail: string;
    hospital: string | null;
    ratings: number;
    price: number;
    visit: number;
}



function DoctorList() {
    // const [doctors, setDoctors] = useState<DoctorCardProps[]>([]);
    //
    // useEffect(() => {
    //     const fetchDoctors = async () => {
    //         try {
    //             const data = await getDoctors();
    //             setDoctors(data);
    //         } catch (error) {
    //             console.error("Failed to fetch doctors:", error);
    //         }
    //     };
    //
    //     fetchDoctors();
    // }, []);

    return (
        <div className="p-4">
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
                {doctorsData.map((doctor) => (
                    <DoctorItemCard key={doctor.id} {...doctor} />
                ))}
            </div>

        </div>
    );
}

export default DoctorList;
