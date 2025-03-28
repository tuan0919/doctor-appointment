import React, { useState } from 'react';

interface TimeSlot {
    start: number;
    end: number;
    maxPatients: number;
}

interface ScheduleProps {
    schedule: { [date: string]: TimeSlot[] };
}


const Schedule: React.FC<ScheduleProps> = ({ schedule }) => {
    const [selectedDate, setSelectedDate] = useState<string | null>(null);
    const [selectedSlot, setSelectedSlot] = useState<TimeSlot | null>(null);

    const handleSelectDate = (date: string) => {
        setSelectedDate(date);
        setSelectedSlot(null); // Reset khi đổi ngày
    };

    const handleSelectSlot = (slot: TimeSlot) => {
        setSelectedSlot(slot);
    };

    return (
        <div className="max-w-md mx-auto mt-8 p-4 bg-white shadow-lg rounded-lg">
            <h4 className="text-2xl font-bold text-center mb-4 text-blue-600">Lịch làm việc</h4>
            <div className="space-y-4 max-h-[500px] overflow-y-auto">
                {Object.entries(schedule).map(([date, slots]) => (
                    <div key={date} className="bg-gray-50 p-3 rounded-lg shadow-sm">
                        {/* Ngày khám */}
                        <div
                            onClick={() => handleSelectDate(date)}
                            className={`text-lg font-semibold cursor-pointer p-2 rounded-lg text-center transition-all ${
                                selectedDate === date ? 'bg-blue-500 text-white' : 'hover:bg-blue-100'
                            }`}
                        >
                            {new Date(date).toLocaleDateString('vi-VN', { weekday: 'long', day: '2-digit', month: '2-digit' })}
                        </div>

                        {/* Khung giờ */}
                        {selectedDate === date && (
                            <div className="flex flex-wrap gap-2 mt-3 justify-center">
                                {slots.length > 0 ? (
                                    slots.map((slot, index) => (
                                        <button
                                            key={index}
                                            onClick={() => handleSelectSlot(slot)}
                                            className={`px-4 py-2 text-sm rounded-lg transition-all shadow-md ${
                                                selectedSlot === slot
                                                    ? 'bg-red-500 text-white'
                                                    : 'bg-gray-200 hover:bg-green-100 hover:text-green-600'
                                            }`}
                                        >
                                            {slot.start}h - {slot.end}h ({slot.maxPatients} BN)
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

            {/* Hiển thị thông tin đã chọn */}
            {selectedDate && selectedSlot && (
                <div className="mt-4 text-center text-green-600">
                    Bạn chọn ngày <strong>{new Date(selectedDate).toLocaleDateString('vi-VN')}</strong> khung giờ <strong>{selectedSlot.start}h - {selectedSlot.end}h</strong>
                </div>
            )}
        </div>
    );
};

export default Schedule;
