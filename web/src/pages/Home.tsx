import DoctorList from "./DoctorList.tsx";

function Home() {
    return (
        <div className="max-w">
            {/*<div className='flex flex-column'>*/}
            {/*    <DoctorList/>*/}
            {/*</div>*/}
            <div className="flex flex-col items-center gap-4">
                <DoctorList/>
                <button className="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600">
                    Xem thêm
                </button>
            </div>

        </div>
    );
}

export default Home;
