import React from "react";
import {DoctorCardProps} from "../pages/DoctorList.tsx";


const DoctorItemCard: React.FC<DoctorCardProps> = ({
                                                       name, hospital, price, ratings, specialization, thumbnail, visit
                                                   }) => {

    return (
        <div className="max-w-xs bg-white rounded-2xl shadow-lg p-4 border border-gray-200">
            <div className="flex flex-col items-center">
                <img
                    src={thumbnail}
                    alt={name}
                    className="w-24 h-24 rounded-full border-4 border-blue-300 object-cover"
                />
                <div className="mt-2 text-center">
                    <p className="text-gray-700 font-medium">
                        Đánh giá: <span className="text-yellow-500">{ratings} ★</span>
                    </p>
                    <p className="text-gray-700">
                        Lượt khám: <span className="text-blue-500 font-semibold">{visit}</span>
                    </p>
                </div>
            </div>
            <div className="mt-4">
                <h3 className="text-lg font-semibold text-gray-800">
                    Ths BS. {name} - {hospital}
                </h3>
                <p className="text-gray-500 flex items-center">🔹 {specialization}</p>
                <p className="text-gray-500 flex items-center">💰 {price.toLocaleString()}đ</p>
                <p className="text-gray-500 flex items-center">🏥 Nơi làm việc</p>
            </div>
            <button
                className="mt-4 w-full bg-blue-500 text-white font-semibold py-2 rounded-lg shadow hover:bg-blue-600">
                Xem chi tiết
            </button>
        </div>
    );
};

export default DoctorItemCard;