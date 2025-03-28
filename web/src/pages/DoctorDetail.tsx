
import DoctorList from "./DoctorList.tsx";
import CardDoctor from "../components/CardDoctor.tsx";
import Schedule from "../components/Schedule.tsx";
import {useEffect, useState} from "react";
import axios from "axios";
import {useParams} from "react-router-dom";

function DoctorDetail() {
    const { id } = useParams(); // Lấy id từ URL
    const [doctor, setDoctor] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchDoctor = async () => {
            try {
                const response = await axios.get(`doctor/details?id=${id}`);
                if (response.data.code === 200) {
                    setDoctor(response.data.result);
                } else {
                    throw new Error(response.data.message || 'Failed to fetch doctor data');
                }
            } catch (error) {
                console.error(error);
            } finally {
                setLoading(false);
            }
        };

        fetchDoctor();
    }, [id]); // Chỉ gọi API khi id thay đổi


    const handleBookAppointment = (doctorId: number) => {
        alert(`Đặt khám thành công cho bác sĩ có ID: ${doctorId}`);
    };

    if (loading) return <div className="text-center text-gray-500">Đang tải...</div>;
    if (!doctor) return <div className="text-center text-red-500">Không tìm thấy bác sĩ.</div>;

    return (
        <div className="max-w">
            <main className="max-w">
                <CardDoctor doctor={doctor} onBookAppointment={handleBookAppointment} />
                <Schedule schedule={doctor} />
                <div className="bg-white rounded-2xl shadow-lg p-4 border border-gray-200 my-4">
                    <h2 className="text-xl font-semibold text-blue-500 mb-4 text-left">Bác sĩ cùng chuyên khoa</h2>
                    <DoctorList />
                </div>
            </main>
        </div>
    );
}

export default DoctorDetail;
