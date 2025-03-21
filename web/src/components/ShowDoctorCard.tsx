import { useState } from "react";
import DoctorItemCard, { DoctorCardProps } from "./DoctorCard.tsx";

const ITEMS_PER_PAGE = 6;

function ShowDoctorCard({ doctors }: { doctors: DoctorCardProps[] }) {
    const [currentPage, setCurrentPage] = useState(1);

    const totalPages = Math.ceil(doctors.length / ITEMS_PER_PAGE);
    const startIndex = (currentPage - 1) * ITEMS_PER_PAGE;
    const currentDoctors = doctors.slice(startIndex, startIndex + ITEMS_PER_PAGE);

    return (
        <div className="max-w-6xl mx-auto py-4">
            
                <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-5">
                    {currentDoctors.map((doctor, index) => (
                        <DoctorItemCard key={index} {...doctor} />
                    ))}
                </div>


            {totalPages > 1 && (
                <div className="flex justify-center mt-4">
                    <button
                        className="px-4 py-2 mx-2 text-white bg-blue-500 rounded disabled:bg-gray-400"
                        onClick={() => setCurrentPage(currentPage - 1)}
                        disabled={currentPage === 1}
                    >
                        Previous
                    </button>

                    {Array.from({ length: totalPages }, (_, index) => (
                        <button
                            key={index + 1}
                            className={`px-4 py-2 mx-1 rounded ${
                                currentPage === index + 1 ? "bg-blue-700 text-white" : "bg-gray-300"
                            }`}
                            onClick={() => setCurrentPage(index + 1)}
                        >
                            {index + 1}
                        </button>
                    ))}

                    <button
                        className="px-4 py-2 mx-2 text-white bg-blue-500 rounded disabled:bg-gray-400"
                        onClick={() => setCurrentPage(currentPage + 1)}
                        disabled={currentPage === totalPages}
                    >
                        Next
                    </button>
                </div>
            )}
        </div>
    );
}

export default ShowDoctorCard;
