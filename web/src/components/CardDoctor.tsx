
interface Doctor {
    id: number;
    name: string;
    image: string;
    specialties: string[];
    price: number;
    introduction: string;
}

interface CardDoctorProps {
    doctor: Doctor;
    onBookAppointment: (id: number) => void;
}

function CardDoctor({ doctor, onBookAppointment }: CardDoctorProps) {
    return (
        <div className="max-w bg-white rounded-2xl shadow-lg p-4 border border-gray-200 flex my-3">
            {/* Hình ảnh bác sĩ */}
            <div className="w-4/12 flex justify-center items-center max-w">
                <img
                    src={doctor.image}
                    alt={doctor.name}
                    className="rounded-full w-24 h-24 object-cover"
                />
            </div>

            {/* Thông tin bác sĩ */}
            <div className="w-8/12 pl-4 flex flex-col justify-between">
                <div>
                    <h3 className="text-xl font-bold">{doctor.name}</h3>
                    <p className="text-sm text-gray-500">{doctor.specialties.join(', ')}</p>
                    <p className="text-lg text-red-500 font-semibold mt-2">{doctor.price.toLocaleString()} VND</p>
                    <p className="text-sm text-gray-600 mt-2">{doctor.introduction}</p>
                    <p className="text-sm text-gray-600 mt-2">{doctor.introduction}</p>
                </div>

                <button
                    onClick={() => onBookAppointment(doctor.id)}
                    className="mt-4 bg-blue-500 hover:bg-blue-600 text-white py-2 px-4 rounded-lg transition-all"
                >
                    Đặt khám
                </button>
            </div>
        </div>
    );
}

export default CardDoctor;
