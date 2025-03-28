import CardDoctor from "../components/CardDoctor.tsx";
import Schedule from "../components/Schedule.tsx";
import {useEffect, useState} from "react";
import axios from "axios";
import {useParams, useSearchParams} from "react-router-dom";
import Search from "./Search.tsx";

function DoctorDetail() {
    const [searchParams] = useSearchParams();
    const id = searchParams.get("id");
    const [doctor, setDoctor] = useState<any>(null);

    useEffect(() => {
        if (id) {
            axios.get(`http://localhost:8081/api/doctor/details?id=${id}`)
                .then((res) => setDoctor(res.data))
                .catch((err) => console.error(err));
        }
    }, [id]);

    if (!doctor) return <p>Đang tải thông tin bác sĩ...</p>;



    const handleBookAppointment = (doctorId: number) => {
        alert(`Đặt khám thành công cho bác sĩ có ID: ${doctorId}`);
    };

    if (!doctor) return <div className="text-center text-red-500">Không tìm thấy bác sĩ.</div>;

    return (
        <div className="max-w">
            <main className="max-w">
                <CardDoctor doctor={doctor} onBookAppointment={handleBookAppointment} />
                <Schedule schedule={doctor} />
                <div className="bg-white rounded-2xl shadow-lg p-4 border border-gray-200 my-4">
                    <h2 className="text-xl font-semibold text-blue-500 mb-4 text-left">Bác sĩ cùng chuyên khoa</h2>
                    <Search />
                </div>
            </main>
        </div>
    );
}

export default DoctorDetail;
