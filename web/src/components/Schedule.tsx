import React, { useState } from 'react';

interface ScheduleProps {
    schedule: { [key: string]: number[] };
}

const daysOfWeek: { [key: string]: string } = {
    monday: 'Thứ Hai',
    tuesday: 'Thứ Ba',
    wednesday: 'Thứ Tư',
    thursday: 'Thứ Năm',
    friday: 'Thứ Sáu',
    saturday: 'Thứ Bảy',
    sunday: 'Chủ Nhật'
};

const Schedule: React.FC<ScheduleProps> = ({ schedule }) => {
    const [selectedDay, setSelectedDay] = useState<string | null>(null);
    const [selectedHour, setSelectedHour] = useState<number | null>(null);

    const handleSelectDay = (day: string) => {
        setSelectedDay(day);
        setSelectedHour(null); // Reset giờ khi đổi ngày
    };

    const handleSelectHour = (hour: number) => {
        setSelectedHour(hour);
    };

    return (
        <div className="max-w-md mx-auto mt-8 p-4 bg-white shadow-lg rounded-lg">
            <h4 className="text-2xl font-bold text-center mb-4 text-blue-600">Lịch làm việc</h4>
            <div className="space-y-4">
                {Object.entries(schedule).map(([day, hours]) => (
                    <div key={day} className="bg-gray-50 p-3 rounded-lg shadow-sm">
                        {/* Tên ngày */}
                        <div
                            onClick={() => handleSelectDay(day)}
                            className={`text-lg font-semibold cursor-pointer p-2 rounded-lg text-center transition-all ${
                                selectedDay === day ? 'bg-blue-500 text-white' : 'hover:bg-blue-100'
                            }`}
                        >
                            {daysOfWeek[day.toLowerCase()] || day}
                        </div>

                        {/* Giờ khám */}
                        {selectedDay === day && (
                            <div className="flex flex-wrap gap-2 mt-3 justify-center">
                                {hours.length > 0 ? (
                                    hours.map((hour) => (
                                        <button
                                            key={hour}
                                            onClick={() => handleSelectHour(hour)}
                                            className={`px-4 py-2 text-sm rounded-lg transition-all shadow-md ${
                                                selectedHour === hour
                                                    ? 'bg-red-500 text-white'
                                                    : 'bg-gray-200 hover:bg-green-100 hover:text-green-600'
                                            }`}
                                        >
                                            {hour}h
                                        </button>
                                    ))
                                ) : (
                                    <span className="text-gray-500 italic">Nghỉ</span>
                                )}
                            </div>
                        )}
                    </div>
                ))}
            </div>
        </div>
    );
};

export default Schedule;
