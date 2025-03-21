
import InformationDoctor from "../components/InformationDoctor.tsx";
import DoctorList from "./DoctorList.tsx";
import CardDoctor from "../components/CardDoctor.tsx";
import Schedule from "../components/Schedule.tsx";
import {useEffect, useState} from "react";
import axios from "axios";

function DoctorDetail() {
    const [doctor, setDoctor] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchDoctor = async () => {
            try {
                const response = await axios.get('doctor/details?id=1');
                if (response.data.code === 200) {
                    setDoctor(response.data.result);
                } else {
                    throw new Error(response.data.message || 'Failed to fetch doctor data');
                }
            }
             finally {
                setLoading(false);
            }
        };

        fetchDoctor();
    },  [doctor]);


    const handleBookAppointment = (id: number) => {
        alert(`Đặt khám thành công cho bác sĩ có ID: ${id}`);
    };

    if (loading) return <div>Đang tải...</div>;

    if(doctor == null) return;

    return (
        <div className="max-w">
            <main className="max-w">
                <CardDoctor doctor={doctor} onBookAppointment={handleBookAppointment} />

                <Schedule schedule={doctor} />


                {/*<InformationDoctor/>*/}
                {/*<InformationDoctor/>*/}
                <div className="bg-white rounded-2xl shadow-lg p-4 border border-gray-200 my-4">
                    <h2 className="text-xl font-semibold text-blue-500 mb-4 text-left">Bác sĩ cùng chuyên khoa</h2>
                    <DoctorList/>

                </div>
            </main>

        </div>
    );
}

export default DoctorDetail
