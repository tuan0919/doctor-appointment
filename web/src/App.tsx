import './App.css'
import DoctorItemCard from "./components/DoctorItemCard.tsx";

function App() {

  return (
      <div className="p-4">
          {/* Hiển thị danh sách bác sĩ theo dạng lưới 4 cột */}
          <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
          </div>
      </div>
  )
}

export default App
